public class cadcam {
    
     public static void main(String[] args) {
        //replace with the actual cpuid
        String cpuid = "000CF1009BDE".substring(4);
        //replace with the actuall appid
        String appid = "PDC";
        //replace with the actual version
        String version = "30";
        //replaced with desired versions
        String startdate = "20040101";
        String enddate = "20200101";
        
        String gen1;
        String gen2;
        
        gen1 = startdate.substring(0,4) + appid.substring(0,2) + startdate.substring(4,6) + appid.substring(2) + "X" + 
               startdate.substring(6,8) + cpuid.substring(0,4) + "9999";
        gen2 = enddate.substring(0,4) + cpuid.substring(4,6) + enddate.substring(4,6) + cpuid.substring(6,8) + 
               enddate.substring(6,8) + version.substring(0,2) + "  " + "ZZZZ";
        System.out.println(cryp(gen1));
        System.out.println(cryp(modu(gen1, gen2)));
        
    }
    
    public static String modu(String inp1,String inp2) {
        int counter = 0;
        String gna = "";
        for(int i = 0; i < inp1.length(); i++) {
            counter += inp1.charAt(i) % 0x64;
        }
        for(int i = 0; i < inp2.length(); i++) {
            counter += inp2.charAt(i) % 0x64;
        }
        if(counter % 0x64 < 0x10) gna = "0" + Integer.toString(counter%0x64, 16).toUpperCase();
        else gna = Integer.toString(counter%0x64, 16).toUpperCase();
        return(inp2.substring(0,14) + gna + inp2.substring(16,20));
    }
    
    public static String cryp(String input) {
        String s1 = "9CkBAzuaYZbcd7ywtvUVWXef5MKJHGFjghNPQ3EDsrqpRST2mnxL";
        String s2 = "aYZbcdUVWXefghNPQRSTmnpqrIDEFGHJKMtwyzABCL0123456789";
        String output = "";
        for(int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') output += s1.charAt(s2.indexOf(input.charAt(i)));
            else output += " ";
        }
        return(output);
    }
    
}
