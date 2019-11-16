package gblerning3Lesson1hw;


        import java.sql.Timestamp;

public interface IDBPers {

    void setConnectParam(IProp p);
    void createConnectToDB(String s);
    long selectLastValue(String s);
    void insertTick(String Instr, String ts,double ask,double bid,double askvol,double bidvol,double asktotalvol,double bidtotalvol);


}