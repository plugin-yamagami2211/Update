package jp.yama2211.update;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UpdateCheck {

    /*
    *  プラグインの最新のバージョンを取得する
    * */

    private String PLName;
    public UpdateCheck(String update) {
        this.PLName = update;
    }


    public String[] getVersion() {
        try{
            StringBuilder result = new StringBuilder();

            URL CheckURL = new URL("https://yama2211.xyz/Json/"+PLName);
            HttpURLConnection con = (HttpURLConnection)CheckURL.openConnection();
            con.connect();
            BufferedReader in = new BufferedReader((new InputStreamReader(con.getInputStream())));

            String line;
            while ((line = in.readLine()) != null){
                result.append(line);
            }

            in.close();
            con.disconnect();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(result.toString());


            String[] version = new String[2];
            version[0] = root.get("Version").asText();
            version[1] = root.get("Message").asText();

            return version;
        }
        catch (Exception err){
            return null;
        }
    }
}
