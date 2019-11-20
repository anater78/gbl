package gblerning3Lesson1hw;


        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;
        import java.sql.Timestamp;


public class DBPers implements IDBPers {
    String dbuser;
    String dbpass;
    String dburl;
    String dbbase;

    Connection conn;
    Statement stmt;
    ResultSet rs;

    private DBPers() {};

    static IDBPers createProp() {
        return new DBPers();}

    public void setConnectParam(IProp p) {

        dbuser = p.getDBUser();
        System.out.println(p.getDBUser());

        dbpass = p.getDBPass();
        System.out.println(p.getDBPass());

        dburl = p.getDBURL();
        System.out.println(p.getDBURL());

        dbbase = p.getDBBaseName();
        System.out.println(p.getDBBaseName());

    }

    public void createConnectToDB(String instrName) {
        String instrNameCToDB = instrName;
        boolean tableCreated = false;

        try {
            conn = DriverManager.getConnection(dburl, dbuser, dbpass);

            stmt = conn.createStatement();
            rs = stmt.executeQuery("show databases;");

            while (rs.next()) {

                if (rs.getString(1).equals(dbbase) ) {
                    System.out.println("db = "+rs.getString(1));
                    rs = stmt.executeQuery("use " + dbbase);
                }
            }

            rs = stmt.executeQuery("show tables;");

            while (rs.next()) {

                if (rs.getString(1).equals(instrNameCToDB+"ticktest") ) {
                    System.out.println("table = "+rs.getString(1));
                    tableCreated = true;
                }
            }

            if(!tableCreated){
                rs = stmt.executeQuery("CREATE TABLE `"
                        + instrNameCToDB
                        + "ticktest` ("
                        + " `id` int(11) NOT NULL AUTO_INCREMENT,"
                        + " `ts` datetime(3) DEFAULT NULL,"
                        + "`ask` double DEFAULT NULL,"
                        + "`bid` double DEFAULT NULL,"
                        + "`askvol` double DEFAULT NULL,"
                        + "`bidvol` double DEFAULT NULL,"
                        + "`asktotalvol` double DEFAULT NULL,"
                        + "`bidtotalvol` double DEFAULT NULL,"
                        + "PRIMARY KEY (`id`),"
                        + "KEY `ts` (`ts`)"
                        + ") ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;");
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public long selectLastValue(String instrName) {
        String instrNameSLV= instrName;
        long ret=0;
        try {
            rs = stmt.executeQuery("SELECT ts FROM "
                    + instrNameSLV+"ticktest"
                    + " ORDER BY id DESC LIMIT 1;");
            System.out.println(" instrName = "  + instrNameSLV);

            while(rs.next()) {

                System.out.println(ret = rs.getTimestamp(1).getTime());
                System.out.println("rs.getFetchSize = "+ rs.getString(1));

            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ret;
    }



    @Override
    public void insertTick(String Instr, String ts, double ask, double bid, double askvol, double bidvol,
                           double asktotalvol, double bidtotalvol) {

//			rs=stmt.executeQuery("insert into "
//			System.out.println("insert into "
        try {
            rs=stmt.executeQuery("insert into "
                    + Instr
                    + "ticktest ( `ts`, `ask`, `bid`, `askvol`, `bidvol`, `asktotalvol`, `bidtotalvol`) values ('"
                    + ts
                    + "' , "
                    + ask
                    + " , "
                    + bid
                    + " , "
                    + askvol
                    + " , "
                    + bidvol
                    + " , "
                    + asktotalvol
                    + " , "
                    + bidtotalvol
                    + " ) "
            );
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

