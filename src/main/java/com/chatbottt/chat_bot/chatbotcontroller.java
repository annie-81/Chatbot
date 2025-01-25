package com.chatbottt.chat_bot;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chatbot")
public class chatbotcontroller {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/message")
    @ResponseBody
    public HttpEntity<String> chat(@RequestBody String input) {
        return getResponse(input);
    }

    private HttpEntity<String> getResponse(String input) {
        HttpHeaders headers = new HttpHeaders();
        String responseText;

        if (input.toLowerCase().contains("timetable")) {
            headers.setContentType(MediaType.TEXT_HTML);
            String timetableHtml = "<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8'>" +
                    "<title>Class Time Table</title><style>body { font-family: Arial, sans-serif; line-height: 1.6; margin: 0; padding: 20px; }" +
                    "table { width: 100%; border-collapse: collapse; } th, td { border: 1px solid #ddd; padding: 8px; text-align: center; }" +
                    "th { background-color: #f2f2f2; } .lab-hours { background-color: #ffcccb; } .odd-row { background-color: #f8f8f8; }" +
                    "tfoot { background-color: #e6e6e6; font-weight: bold; }</style></head><body><table><thead><tr><th colspan='10'>5A Class Time Table</th></tr>" +
                    "<tr><th>Time</th><th>8:30 - 9:30</th><th>9:30 - 10:30</th><th>10:30 - 10:50</th><th>10:50 - 11:50</th><th>11:50 - 12:50</th>" +
                    "<th>12:50 - 1:45</th><th>1:45 - 2:40</th><th>2:40 - 3:35</th><th>3:35 - 4:30</th></tr></thead><tbody>" +
                    "<tr><td>Monday</td><td class='lab-hours' colspan='2'>A1 WEB/A2 CN LAB</td><td rowspan='6'>Short Break</td><td>SE</td><td>TOC</td>" +
                    "<td rowspan='6'>Lunch Break</td><td colspan='3'>MINI PROJECT</td></tr>" +
                    "<tr class='odd-row'><td>Tuesday</td><td class='lab-hours' colspan='2'>A1 CN/A2 WEB LAB</td><td>TOC</td><td>AI</td><td>RM(TUT)</td>" +
                    "<td colspan='2'>TUTORIAL</td></tr>" +
                    "<tr><td>Wednesday</td><td>CN</td><td>AI</td><td>RM</td><td>TUT</td><td colspan='3'>TUTORIAL</td></tr>" +
                    "<tr class='odd-row'><td>Thursday</td><td>SE</td><td>TOC</td><td>CN</td><td>RM</td><td colspan='3'>TUTORIAL</td></tr>" +
                    "<tr><td>Friday</td><td>TOC</td><td>SE</td><td>CN</td><td>RM</td><td colspan='3'>FORUM ACTIVITY</td></tr>" +
                    "<tr><td>Saturday</td><td>ENV</td><td>AI</td><td>SE</td><td>TOC(TUT)</td><td colspan='3'></td></tr>" +
                    "</tbody><tfoot><tr><td colspan='10'>* Lab Hours are highlighted in pink</td></tr></tfoot></table></body></html>";
            return new HttpEntity<>(timetableHtml, headers);
        } else {
            headers.setContentType(MediaType.TEXT_PLAIN);

            if (input.toLowerCase().contains("hi") || input.toLowerCase().contains("hello")) {
                responseText = "Hello! How can I help you today?";
            } else if (input.toLowerCase().contains("how are you")) {
                responseText = "I'm just a program, but I'm doing fine!";
            } else if (input.toLowerCase().contains("courses")) {
                responseText = "Computer Science & Engineering, Information Science & Engineering, Electronics and Communication Engineering, Electrical and Electronics Engineering, Mechanical Engineering, Civil Engineering, BioTechnology";
            } else if (input.toLowerCase().contains("timings")) {
                responseText = "Mon to Fri- 8:30 to 4:00, Sat-8:30 to 12:50";
            } else if (input.toLowerCase().contains("cet code")) {
                responseText = "E108";
            } else if (input.toLowerCase().contains("prerequisites")) {
                responseText = "PUC or Diploma";
            } else if (input.toLowerCase().contains("hostel available")) {
                responseText = "Yes";
            } else {
                responseText = "Sorry, I don't understand your question.";
            }
            return new HttpEntity<>(responseText, headers);
        }
    }
}
