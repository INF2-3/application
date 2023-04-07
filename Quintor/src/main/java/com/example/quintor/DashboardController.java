package com.example.quintor;


import com.example.quintor.dataobjects.BankStatement;
import com.example.quintor.dataobjects.User;
import com.example.quintor.getdata.GetBankStatement;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DashboardController extends SceneController implements Initializable {
    @FXML
    public AnchorPane embeddedNav;
    @FXML
    private VBox mainVBox;
    @FXML
    private VBox dashboardBox;
    @FXML
    private Label clubName;
    @FXML
    private TableColumn<BankStatement, String> columnAccountNumber;
    @FXML
    private TableColumn<BankStatement, String> columnFileDate;
    @FXML
    private TableColumn<BankStatement, Integer> columnFileId;
    @FXML
    private TableColumn<BankStatement, User> columnFileUploader;
    @FXML
    private TableColumn<BankStatement, Double> columnFinalBalance;
    @FXML
    private TableView<BankStatement> transcriptTable;
    @FXML
    private Button uploadButton;
    private int userId = 1;
    private final String success = "success";

    //getter and setter for the user id
    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        if (userId >= 0) {
            this.userId = userId;
        }
    }

    /**
     * This method gets called automatically when the contents of the fxml file are fully loaded
     * to perform post-processing on the content
     * It creates cell factory's for the table, then adds every transcript to an observable list and adds the
     * observable list to the transactions table.
     *
     * @param url            The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnFileId.setCellValueFactory(new PropertyValueFactory<BankStatement, Integer>("id"));
        columnFileDate.setCellValueFactory(new PropertyValueFactory<BankStatement, String>("uploadDate"));
        columnFileUploader.setCellValueFactory(new PropertyValueFactory<BankStatement, User>("userName"));
        columnFinalBalance.setCellValueFactory(new PropertyValueFactory<BankStatement, Double>("finalBalance"));
        columnAccountNumber.setCellValueFactory(new PropertyValueFactory<BankStatement, String>("accountNumber"));

        List<BankStatement> allBankstatements = GetBankStatement.getBankStatementsXML();
        ObservableList<BankStatement> bankStatements = transcriptTable.getItems();
        bankStatements.addAll(allBankstatements);
        transcriptTable.setItems(bankStatements);

        transcriptTable.setRowFactory(tv -> {
            TableRow<BankStatement> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !row.isEmpty()) {
                    BankStatement bankStatement = row.getItem();
                    TransactionOverviewController.setFileId(bankStatement.getId());
                    try {
                        changeView("transactionsOverview", embeddedNav);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            return row;
        });
    }

    /**
     * This method is called when the user preses the upload file button on the dashboard.
     * This method allows you to upload a file
     */
    public void uploadButtonAction() {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("MT940 files", "*.940"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT files", "*.txt"));
        File f = fc.showOpenDialog(null);
        if (f != null) {
            try {
                if (uploadFile(f, userId)) {
                    uploadToPostgres(f, userId);
                }
            } catch (IOException error) {
                error.printStackTrace();
            }
        }
    }

    /**
     * This method uploads a mt940 file to the MongoDB through a POST request to the
     * api.
     *
     * @param file   The file which should be uploaded.
     * @param userId The user id of the user who uploads the file.
     * @return return true when the file has been uploaded and false when something
     * went wrong.
     * @throws IOException
     */
    private boolean uploadFile(File file, int userId) throws IOException {
        if (file == null || !file.isFile() || !file.exists()) {
            return false;
        }
        if (userId < 0) {
            return false;
        }

        String url = System.getenv("URL_API") + "/api/mt940/insert";
        URL api = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) api.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Accept", "application/json");

        httpURLConnection.setDoOutput(true);
        OutputStream os = httpURLConnection.getOutputStream();
        String params = "userId=" + userId + "&file=" + file;
        os.write(params.getBytes());
        os.flush();
        os.close();
        return getResponse(httpURLConnection);
    }


    /**
     * Call insert endpoint to insert file into database
     *
     * @param file   Uploaded file
     * @param userId id of uploaded user
     * @return Endpoint response
     */
    private boolean uploadToPostgres(File file, int userId) throws IOException {
        if (file == null || !file.isFile() || !file.exists()) {
            return false;
        }
        if (userId < 0) {
            return false;
        }
        HttpURLConnection connection = (HttpURLConnection) new URL((System.getenv("URL_API") + "/api/postgres/insert")).openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);

        OutputStream os = connection.getOutputStream();
        String params = "file=" + file + "&userId=" + userId + "&mode=" + System.getProperty("MODUS");
        os.write(params.getBytes());
        os.flush();
        os.close();

        return getResponse(connection);
    }

    /**
     * Gets the response of a httpURLConnection and puts them in a Stringbuffer.
     *
     * @param httpURLConnection the httpURLConnection used to get the response.
     * @return true or false based on the response of the api.
     * @throws IOException
     */
    private boolean getResponse(HttpURLConnection httpURLConnection) throws IOException {
        if (httpURLConnection == null) {
            return false;
        }
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            if (response.toString().equals(success)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
