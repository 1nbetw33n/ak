package intern3;

final public class LFSR implements LFRSable{


    private String hexValue;


    public LFSR(final String HEXVALUE){
        this.hexValue = HEXVALUE;
    }


    final public byte[] generateByteStream() {
        return new byte[0];
    }
}
