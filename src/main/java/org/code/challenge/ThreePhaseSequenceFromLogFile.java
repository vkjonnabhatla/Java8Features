package org.code.challenge;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ThreePhaseSequenceFromLogFile {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        List<LogRecord> logRecords = new ArrayList();
        logRecords.add(new LogRecord(sdf.parse("01-01-2022 11:15:00"), "vjonnabh", "X"));
        logRecords.add(new LogRecord(sdf.parse("01-01-2022 11:17:00"), "vjonnabh", "Z"));
        logRecords.add(new LogRecord(sdf.parse("01-01-2022 11:16:00"), "vjonnabh", "Y"));
        logRecords.add(new LogRecord(sdf.parse("01-01-2022 11:16:00"), "jraaga", "X"));

        logRecords.add(new LogRecord(sdf.parse("01-01-2022 11:18:00"), "vjonnabh", "A"));
        logRecords.add(new LogRecord(sdf.parse("01-01-2022 11:20:00"), "vjonnabh", "B"));
        logRecords.add(new LogRecord(sdf.parse("01-01-2022 11:21:00"), "vjonnabh", "C"));
        logRecords.add(new LogRecord(sdf.parse("01-01-2022 11:22:00"), "jraaga", "Y"));
        logRecords.add(new LogRecord(sdf.parse("01-01-2022 11:23:00"), "jraaga", "Z"));
        final Map<String, Integer> finalPageSequenceMap = new HashMap<>();
        Map<String, List<LogRecord>> map = logRecords.stream().collect(Collectors.groupingBy(logRecord -> logRecord.getUserId(), Collectors.toList()));
        Comparator<LogRecord> comparator = (c1, c2) -> c1.getTimeStamp().compareTo(c2.getTimeStamp());
        map.entrySet().stream()
                .map(stringListEntry -> {
                    Collections.sort(stringListEntry.getValue(), comparator);
                    return stringListEntry;
                 })
                .forEach(stringListEntry -> {
                    int number = stringListEntry.getValue().size();
                    List<LogRecord> list = stringListEntry.getValue();
                    for(int i = 0; i < number - 2; i++){
                        if(finalPageSequenceMap.containsKey(""+list.get(i).getWebpageId()+list.get(i+1).getWebpageId()+list.get(i+2).getWebpageId())){
                            finalPageSequenceMap.put(""+list.get(i).getWebpageId()+list.get(i+1).getWebpageId()+list.get(i+2).getWebpageId(), finalPageSequenceMap.get(""+list.get(i).getWebpageId()+list.get(i+1).getWebpageId()+list.get(i+2).getWebpageId()) + 1);
                        }else{
                            finalPageSequenceMap.put(""+list.get(i).getWebpageId()+list.get(i+1).getWebpageId()+list.get(i+2).getWebpageId(), 1);
                        }
                    }
                });

        Map<String, Integer> pageMap = finalPageSequenceMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2)-> e2, LinkedHashMap::new));

        System.out.println(pageMap);








    }

}

class LogRecord{
    public Date timeStamp;
    public String userId;
    public String webpageId;

    public LogRecord(Date timeStamp, String userId, String webpageId){
        this.timeStamp = timeStamp;
        this.userId = userId;
        this.webpageId = webpageId;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getWebpageId() {
        return webpageId;
    }

    public void setWebpageId(String webpageId) {
        this.webpageId = webpageId;
    }

    @Override
    public String toString() {
        return "LogRecord{" +
                "timeStamp=" + timeStamp +
                ", userId='" + userId + '\'' +
                ", webpageId='" + webpageId + '\'' +
                '}';
    }
}
