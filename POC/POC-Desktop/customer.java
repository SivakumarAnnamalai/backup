// ORM class for table 'customer'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Tue Jun 07 11:15:05 IST 2016
// For connector: org.apache.sqoop.manager.MySQLManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import com.cloudera.sqoop.lib.JdbcWritableBridge;
import com.cloudera.sqoop.lib.DelimiterSet;
import com.cloudera.sqoop.lib.FieldFormatter;
import com.cloudera.sqoop.lib.RecordParser;
import com.cloudera.sqoop.lib.BooleanParser;
import com.cloudera.sqoop.lib.BlobRef;
import com.cloudera.sqoop.lib.ClobRef;
import com.cloudera.sqoop.lib.LargeObjectLoader;
import com.cloudera.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class customer extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  protected ResultSet __cur_result_set;
  private String ID;
  public String get_ID() {
    return ID;
  }
  public void set_ID(String ID) {
    this.ID = ID;
  }
  public customer with_ID(String ID) {
    this.ID = ID;
    return this;
  }
  private Integer TransactionAmount;
  public Integer get_TransactionAmount() {
    return TransactionAmount;
  }
  public void set_TransactionAmount(Integer TransactionAmount) {
    this.TransactionAmount = TransactionAmount;
  }
  public customer with_TransactionAmount(Integer TransactionAmount) {
    this.TransactionAmount = TransactionAmount;
    return this;
  }
  private Integer BuildingNumber;
  public Integer get_BuildingNumber() {
    return BuildingNumber;
  }
  public void set_BuildingNumber(Integer BuildingNumber) {
    this.BuildingNumber = BuildingNumber;
  }
  public customer with_BuildingNumber(Integer BuildingNumber) {
    this.BuildingNumber = BuildingNumber;
    return this;
  }
  private String StreetName;
  public String get_StreetName() {
    return StreetName;
  }
  public void set_StreetName(String StreetName) {
    this.StreetName = StreetName;
  }
  public customer with_StreetName(String StreetName) {
    this.StreetName = StreetName;
    return this;
  }
  private String City;
  public String get_City() {
    return City;
  }
  public void set_City(String City) {
    this.City = City;
  }
  public customer with_City(String City) {
    this.City = City;
    return this;
  }
  private String State;
  public String get_State() {
    return State;
  }
  public void set_State(String State) {
    this.State = State;
  }
  public customer with_State(String State) {
    this.State = State;
    return this;
  }
  private Integer ZIP;
  public Integer get_ZIP() {
    return ZIP;
  }
  public void set_ZIP(Integer ZIP) {
    this.ZIP = ZIP;
  }
  public customer with_ZIP(Integer ZIP) {
    this.ZIP = ZIP;
    return this;
  }
  private String Country;
  public String get_Country() {
    return Country;
  }
  public void set_Country(String Country) {
    this.Country = Country;
  }
  public customer with_Country(String Country) {
    this.Country = Country;
    return this;
  }
  private String Phone;
  public String get_Phone() {
    return Phone;
  }
  public void set_Phone(String Phone) {
    this.Phone = Phone;
  }
  public customer with_Phone(String Phone) {
    this.Phone = Phone;
    return this;
  }
  private String eMail;
  public String get_eMail() {
    return eMail;
  }
  public void set_eMail(String eMail) {
    this.eMail = eMail;
  }
  public customer with_eMail(String eMail) {
    this.eMail = eMail;
    return this;
  }
  private String Comments;
  public String get_Comments() {
    return Comments;
  }
  public void set_Comments(String Comments) {
    this.Comments = Comments;
  }
  public customer with_Comments(String Comments) {
    this.Comments = Comments;
    return this;
  }
  private String DoB;
  public String get_DoB() {
    return DoB;
  }
  public void set_DoB(String DoB) {
    this.DoB = DoB;
  }
  public customer with_DoB(String DoB) {
    this.DoB = DoB;
    return this;
  }
  private String Gender;
  public String get_Gender() {
    return Gender;
  }
  public void set_Gender(String Gender) {
    this.Gender = Gender;
  }
  public customer with_Gender(String Gender) {
    this.Gender = Gender;
    return this;
  }
  private String DateMod;
  public String get_DateMod() {
    return DateMod;
  }
  public void set_DateMod(String DateMod) {
    this.DateMod = DateMod;
  }
  public customer with_DateMod(String DateMod) {
    this.DateMod = DateMod;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof customer)) {
      return false;
    }
    customer that = (customer) o;
    boolean equal = true;
    equal = equal && (this.ID == null ? that.ID == null : this.ID.equals(that.ID));
    equal = equal && (this.TransactionAmount == null ? that.TransactionAmount == null : this.TransactionAmount.equals(that.TransactionAmount));
    equal = equal && (this.BuildingNumber == null ? that.BuildingNumber == null : this.BuildingNumber.equals(that.BuildingNumber));
    equal = equal && (this.StreetName == null ? that.StreetName == null : this.StreetName.equals(that.StreetName));
    equal = equal && (this.City == null ? that.City == null : this.City.equals(that.City));
    equal = equal && (this.State == null ? that.State == null : this.State.equals(that.State));
    equal = equal && (this.ZIP == null ? that.ZIP == null : this.ZIP.equals(that.ZIP));
    equal = equal && (this.Country == null ? that.Country == null : this.Country.equals(that.Country));
    equal = equal && (this.Phone == null ? that.Phone == null : this.Phone.equals(that.Phone));
    equal = equal && (this.eMail == null ? that.eMail == null : this.eMail.equals(that.eMail));
    equal = equal && (this.Comments == null ? that.Comments == null : this.Comments.equals(that.Comments));
    equal = equal && (this.DoB == null ? that.DoB == null : this.DoB.equals(that.DoB));
    equal = equal && (this.Gender == null ? that.Gender == null : this.Gender.equals(that.Gender));
    equal = equal && (this.DateMod == null ? that.DateMod == null : this.DateMod.equals(that.DateMod));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof customer)) {
      return false;
    }
    customer that = (customer) o;
    boolean equal = true;
    equal = equal && (this.ID == null ? that.ID == null : this.ID.equals(that.ID));
    equal = equal && (this.TransactionAmount == null ? that.TransactionAmount == null : this.TransactionAmount.equals(that.TransactionAmount));
    equal = equal && (this.BuildingNumber == null ? that.BuildingNumber == null : this.BuildingNumber.equals(that.BuildingNumber));
    equal = equal && (this.StreetName == null ? that.StreetName == null : this.StreetName.equals(that.StreetName));
    equal = equal && (this.City == null ? that.City == null : this.City.equals(that.City));
    equal = equal && (this.State == null ? that.State == null : this.State.equals(that.State));
    equal = equal && (this.ZIP == null ? that.ZIP == null : this.ZIP.equals(that.ZIP));
    equal = equal && (this.Country == null ? that.Country == null : this.Country.equals(that.Country));
    equal = equal && (this.Phone == null ? that.Phone == null : this.Phone.equals(that.Phone));
    equal = equal && (this.eMail == null ? that.eMail == null : this.eMail.equals(that.eMail));
    equal = equal && (this.Comments == null ? that.Comments == null : this.Comments.equals(that.Comments));
    equal = equal && (this.DoB == null ? that.DoB == null : this.DoB.equals(that.DoB));
    equal = equal && (this.Gender == null ? that.Gender == null : this.Gender.equals(that.Gender));
    equal = equal && (this.DateMod == null ? that.DateMod == null : this.DateMod.equals(that.DateMod));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.ID = JdbcWritableBridge.readString(1, __dbResults);
    this.TransactionAmount = JdbcWritableBridge.readInteger(2, __dbResults);
    this.BuildingNumber = JdbcWritableBridge.readInteger(3, __dbResults);
    this.StreetName = JdbcWritableBridge.readString(4, __dbResults);
    this.City = JdbcWritableBridge.readString(5, __dbResults);
    this.State = JdbcWritableBridge.readString(6, __dbResults);
    this.ZIP = JdbcWritableBridge.readInteger(7, __dbResults);
    this.Country = JdbcWritableBridge.readString(8, __dbResults);
    this.Phone = JdbcWritableBridge.readString(9, __dbResults);
    this.eMail = JdbcWritableBridge.readString(10, __dbResults);
    this.Comments = JdbcWritableBridge.readString(11, __dbResults);
    this.DoB = JdbcWritableBridge.readString(12, __dbResults);
    this.Gender = JdbcWritableBridge.readString(13, __dbResults);
    this.DateMod = JdbcWritableBridge.readString(14, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.ID = JdbcWritableBridge.readString(1, __dbResults);
    this.TransactionAmount = JdbcWritableBridge.readInteger(2, __dbResults);
    this.BuildingNumber = JdbcWritableBridge.readInteger(3, __dbResults);
    this.StreetName = JdbcWritableBridge.readString(4, __dbResults);
    this.City = JdbcWritableBridge.readString(5, __dbResults);
    this.State = JdbcWritableBridge.readString(6, __dbResults);
    this.ZIP = JdbcWritableBridge.readInteger(7, __dbResults);
    this.Country = JdbcWritableBridge.readString(8, __dbResults);
    this.Phone = JdbcWritableBridge.readString(9, __dbResults);
    this.eMail = JdbcWritableBridge.readString(10, __dbResults);
    this.Comments = JdbcWritableBridge.readString(11, __dbResults);
    this.DoB = JdbcWritableBridge.readString(12, __dbResults);
    this.Gender = JdbcWritableBridge.readString(13, __dbResults);
    this.DateMod = JdbcWritableBridge.readString(14, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(ID, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(TransactionAmount, 2 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(BuildingNumber, 3 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(StreetName, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(City, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(State, 6 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(ZIP, 7 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(Country, 8 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(Phone, 9 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(eMail, 10 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(Comments, 11 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(DoB, 12 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(Gender, 13 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(DateMod, 14 + __off, 12, __dbStmt);
    return 14;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(ID, 1 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(TransactionAmount, 2 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(BuildingNumber, 3 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(StreetName, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(City, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(State, 6 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(ZIP, 7 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(Country, 8 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(Phone, 9 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(eMail, 10 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(Comments, 11 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(DoB, 12 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(Gender, 13 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(DateMod, 14 + __off, 12, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.ID = null;
    } else {
    this.ID = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.TransactionAmount = null;
    } else {
    this.TransactionAmount = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.BuildingNumber = null;
    } else {
    this.BuildingNumber = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.StreetName = null;
    } else {
    this.StreetName = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.City = null;
    } else {
    this.City = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.State = null;
    } else {
    this.State = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.ZIP = null;
    } else {
    this.ZIP = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.Country = null;
    } else {
    this.Country = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.Phone = null;
    } else {
    this.Phone = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.eMail = null;
    } else {
    this.eMail = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.Comments = null;
    } else {
    this.Comments = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.DoB = null;
    } else {
    this.DoB = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.Gender = null;
    } else {
    this.Gender = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.DateMod = null;
    } else {
    this.DateMod = Text.readString(__dataIn);
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.ID) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, ID);
    }
    if (null == this.TransactionAmount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.TransactionAmount);
    }
    if (null == this.BuildingNumber) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.BuildingNumber);
    }
    if (null == this.StreetName) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, StreetName);
    }
    if (null == this.City) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, City);
    }
    if (null == this.State) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, State);
    }
    if (null == this.ZIP) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.ZIP);
    }
    if (null == this.Country) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Country);
    }
    if (null == this.Phone) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Phone);
    }
    if (null == this.eMail) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, eMail);
    }
    if (null == this.Comments) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Comments);
    }
    if (null == this.DoB) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, DoB);
    }
    if (null == this.Gender) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Gender);
    }
    if (null == this.DateMod) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, DateMod);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.ID) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, ID);
    }
    if (null == this.TransactionAmount) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.TransactionAmount);
    }
    if (null == this.BuildingNumber) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.BuildingNumber);
    }
    if (null == this.StreetName) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, StreetName);
    }
    if (null == this.City) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, City);
    }
    if (null == this.State) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, State);
    }
    if (null == this.ZIP) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.ZIP);
    }
    if (null == this.Country) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Country);
    }
    if (null == this.Phone) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Phone);
    }
    if (null == this.eMail) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, eMail);
    }
    if (null == this.Comments) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Comments);
    }
    if (null == this.DoB) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, DoB);
    }
    if (null == this.Gender) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, Gender);
    }
    if (null == this.DateMod) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, DateMod);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(ID==null?"null":ID, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(TransactionAmount==null?"null":"" + TransactionAmount, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(BuildingNumber==null?"null":"" + BuildingNumber, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(StreetName==null?"null":StreetName, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(City==null?"null":City, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(State==null?"null":State, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(ZIP==null?"null":"" + ZIP, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Country==null?"null":Country, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Phone==null?"null":Phone, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(eMail==null?"null":eMail, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Comments==null?"null":Comments, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(DoB==null?"null":DoB, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Gender==null?"null":Gender, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(DateMod==null?"null":DateMod, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(ID==null?"null":ID, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(TransactionAmount==null?"null":"" + TransactionAmount, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(BuildingNumber==null?"null":"" + BuildingNumber, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(StreetName==null?"null":StreetName, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(City==null?"null":City, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(State==null?"null":State, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(ZIP==null?"null":"" + ZIP, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Country==null?"null":Country, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Phone==null?"null":Phone, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(eMail==null?"null":eMail, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Comments==null?"null":Comments, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(DoB==null?"null":DoB, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Gender==null?"null":Gender, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(DateMod==null?"null":DateMod, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.ID = null; } else {
      this.ID = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.TransactionAmount = null; } else {
      this.TransactionAmount = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.BuildingNumber = null; } else {
      this.BuildingNumber = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.StreetName = null; } else {
      this.StreetName = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.City = null; } else {
      this.City = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.State = null; } else {
      this.State = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.ZIP = null; } else {
      this.ZIP = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Country = null; } else {
      this.Country = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Phone = null; } else {
      this.Phone = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.eMail = null; } else {
      this.eMail = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Comments = null; } else {
      this.Comments = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.DoB = null; } else {
      this.DoB = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Gender = null; } else {
      this.Gender = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.DateMod = null; } else {
      this.DateMod = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.ID = null; } else {
      this.ID = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.TransactionAmount = null; } else {
      this.TransactionAmount = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.BuildingNumber = null; } else {
      this.BuildingNumber = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.StreetName = null; } else {
      this.StreetName = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.City = null; } else {
      this.City = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.State = null; } else {
      this.State = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.ZIP = null; } else {
      this.ZIP = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Country = null; } else {
      this.Country = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Phone = null; } else {
      this.Phone = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.eMail = null; } else {
      this.eMail = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Comments = null; } else {
      this.Comments = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.DoB = null; } else {
      this.DoB = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.Gender = null; } else {
      this.Gender = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.DateMod = null; } else {
      this.DateMod = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    customer o = (customer) super.clone();
    return o;
  }

  public void clone0(customer o) throws CloneNotSupportedException {
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new TreeMap<String, Object>();
    __sqoop$field_map.put("ID", this.ID);
    __sqoop$field_map.put("TransactionAmount", this.TransactionAmount);
    __sqoop$field_map.put("BuildingNumber", this.BuildingNumber);
    __sqoop$field_map.put("StreetName", this.StreetName);
    __sqoop$field_map.put("City", this.City);
    __sqoop$field_map.put("State", this.State);
    __sqoop$field_map.put("ZIP", this.ZIP);
    __sqoop$field_map.put("Country", this.Country);
    __sqoop$field_map.put("Phone", this.Phone);
    __sqoop$field_map.put("eMail", this.eMail);
    __sqoop$field_map.put("Comments", this.Comments);
    __sqoop$field_map.put("DoB", this.DoB);
    __sqoop$field_map.put("Gender", this.Gender);
    __sqoop$field_map.put("DateMod", this.DateMod);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("ID", this.ID);
    __sqoop$field_map.put("TransactionAmount", this.TransactionAmount);
    __sqoop$field_map.put("BuildingNumber", this.BuildingNumber);
    __sqoop$field_map.put("StreetName", this.StreetName);
    __sqoop$field_map.put("City", this.City);
    __sqoop$field_map.put("State", this.State);
    __sqoop$field_map.put("ZIP", this.ZIP);
    __sqoop$field_map.put("Country", this.Country);
    __sqoop$field_map.put("Phone", this.Phone);
    __sqoop$field_map.put("eMail", this.eMail);
    __sqoop$field_map.put("Comments", this.Comments);
    __sqoop$field_map.put("DoB", this.DoB);
    __sqoop$field_map.put("Gender", this.Gender);
    __sqoop$field_map.put("DateMod", this.DateMod);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if ("ID".equals(__fieldName)) {
      this.ID = (String) __fieldVal;
    }
    else    if ("TransactionAmount".equals(__fieldName)) {
      this.TransactionAmount = (Integer) __fieldVal;
    }
    else    if ("BuildingNumber".equals(__fieldName)) {
      this.BuildingNumber = (Integer) __fieldVal;
    }
    else    if ("StreetName".equals(__fieldName)) {
      this.StreetName = (String) __fieldVal;
    }
    else    if ("City".equals(__fieldName)) {
      this.City = (String) __fieldVal;
    }
    else    if ("State".equals(__fieldName)) {
      this.State = (String) __fieldVal;
    }
    else    if ("ZIP".equals(__fieldName)) {
      this.ZIP = (Integer) __fieldVal;
    }
    else    if ("Country".equals(__fieldName)) {
      this.Country = (String) __fieldVal;
    }
    else    if ("Phone".equals(__fieldName)) {
      this.Phone = (String) __fieldVal;
    }
    else    if ("eMail".equals(__fieldName)) {
      this.eMail = (String) __fieldVal;
    }
    else    if ("Comments".equals(__fieldName)) {
      this.Comments = (String) __fieldVal;
    }
    else    if ("DoB".equals(__fieldName)) {
      this.DoB = (String) __fieldVal;
    }
    else    if ("Gender".equals(__fieldName)) {
      this.Gender = (String) __fieldVal;
    }
    else    if ("DateMod".equals(__fieldName)) {
      this.DateMod = (String) __fieldVal;
    }
    else {
      throw new RuntimeException("No such field: " + __fieldName);
    }
  }
  public boolean setField0(String __fieldName, Object __fieldVal) {
    if ("ID".equals(__fieldName)) {
      this.ID = (String) __fieldVal;
      return true;
    }
    else    if ("TransactionAmount".equals(__fieldName)) {
      this.TransactionAmount = (Integer) __fieldVal;
      return true;
    }
    else    if ("BuildingNumber".equals(__fieldName)) {
      this.BuildingNumber = (Integer) __fieldVal;
      return true;
    }
    else    if ("StreetName".equals(__fieldName)) {
      this.StreetName = (String) __fieldVal;
      return true;
    }
    else    if ("City".equals(__fieldName)) {
      this.City = (String) __fieldVal;
      return true;
    }
    else    if ("State".equals(__fieldName)) {
      this.State = (String) __fieldVal;
      return true;
    }
    else    if ("ZIP".equals(__fieldName)) {
      this.ZIP = (Integer) __fieldVal;
      return true;
    }
    else    if ("Country".equals(__fieldName)) {
      this.Country = (String) __fieldVal;
      return true;
    }
    else    if ("Phone".equals(__fieldName)) {
      this.Phone = (String) __fieldVal;
      return true;
    }
    else    if ("eMail".equals(__fieldName)) {
      this.eMail = (String) __fieldVal;
      return true;
    }
    else    if ("Comments".equals(__fieldName)) {
      this.Comments = (String) __fieldVal;
      return true;
    }
    else    if ("DoB".equals(__fieldName)) {
      this.DoB = (String) __fieldVal;
      return true;
    }
    else    if ("Gender".equals(__fieldName)) {
      this.Gender = (String) __fieldVal;
      return true;
    }
    else    if ("DateMod".equals(__fieldName)) {
      this.DateMod = (String) __fieldVal;
      return true;
    }
    else {
      return false;    }
  }
}
