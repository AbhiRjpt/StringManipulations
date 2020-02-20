package com.ranag;

import java.io.*;

public class FileConversion {


    public static void main(String[] args) throws Exception {
        FileConversion fileConversion = new FileConversion();
        fileConversion.createAndWriteFile();
    }

    private void createAndWriteFile() throws IOException {
        File file = new File("/users/abhimanurana/Downloads/test.xlsx");
        if(file.exists())
        file.deleteOnExit();

        Writer writer = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
        writer.write("फ्रीलॉन्स के तौर पर कंटेंट राइटिंग की जॉब तलाश रहे राइटर्स कर सकते हैं आवेदन");
//        writer.write("दोस्तों को ई-मेल लिखने में मदद करते हैं या उनके लिए अच्छे नोट्स बना देते हैं");
        writer.flush();
        writer.close();

    }
}
