package net.byteabyte.location.gps;

public class ChecksumCalculator {
  public static String getChecksum(String sentence){
    int checksum = 0;
    for (int i =0; i<sentence.length(); i++){
      char Character = sentence.charAt(i);
      if (Character == '$'){
        // Ignore the dollar sign
      }else if (Character == '*'){
        // Stop processing before the asterisk
        break;
      }else{
        if (checksum == 0){
          checksum = (byte)Character;
        }
        else{
          checksum = checksum ^ (byte)Character;
        }
      }
    }
    return String.format("%X", checksum);
  }
}
