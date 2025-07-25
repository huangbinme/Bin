package com.interview.scb;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Solution_1 {
    public static String fastestRunner(String marathon, String gender) throws Exception {
        String baseUrl = "https://jsonmock.hackerrank.com/api/marathon?marathon_name="
                + marathon.replace(" ", "%20") + "&sex=" + gender;
        int page = 1;
        int totalPages = 1;

        String fastestName = "";
        double fastestTime = Double.MAX_VALUE;

        while (page <= totalPages) {
            String url = baseUrl + "&page=" + page;
            JSONObject response = getJSONFromURL(url);
            totalPages = response.getInt("total_pages");

            JSONArray data = response.getJSONArray("data");
            for (int i = 0; i < data.length(); i++) {
                JSONObject runner = data.getJSONObject(i);
                double distance = runner.getDouble("distance_run");
                double speed = runner.getDouble("average_speed");
                String name = runner.getString("name");

                // Skip if speed is zero to avoid division by zero
                if (speed == 0) continue;

                double time = Math.round((distance / speed) * 100.0) / 100.0;

                if (time < fastestTime || (time == fastestTime && name.compareTo(fastestName) < 0)) {
                    fastestTime = time;
                    fastestName = name;
                }
            }
            page++;
        }

        return fastestName;
    }

    private static JSONObject getJSONFromURL(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream())
        );

        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null)
            content.append(inputLine);

        in.close();
        con.disconnect();

        return new JSONObject(content.toString());
    }

    static class Runner implements Comparable<Runner>{
        String name;
        Double distance_run;
        Double average_speed;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getDistance_run() {
            return distance_run;
        }

        public void setDistance_run(Double distance_run) {
            this.distance_run = distance_run;
        }

        public Double getAverage_speed() {
            return average_speed;
        }

        public void setAverage_speed(Double average_speed) {
            this.average_speed = average_speed;
        }

        @Override
        public int compareTo(Runner o) {
            return Double.compare(1.1,2.2);
        }
    }

    public static void main(String[] args) {
        System.out.println("ds ds fd %d".replace(" ", "%20"));
        System.out.println(String.format("sds %d",2));
    }
}
