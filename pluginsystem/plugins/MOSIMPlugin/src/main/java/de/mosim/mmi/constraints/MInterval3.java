/*
 * Copyright (C) 2020 Andre Antakli (German Research Center for Artificial Intelligence, DFKI).
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */

package de.mosim.mmi.constraints;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.13.0)", date = "2020-09-11")
public class MInterval3 implements org.apache.thrift.TBase<MInterval3, MInterval3._Fields>, java.io.Serializable, Cloneable, Comparable<MInterval3> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MInterval3");

  private static final org.apache.thrift.protocol.TField X_FIELD_DESC = new org.apache.thrift.protocol.TField("X", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField Y_FIELD_DESC = new org.apache.thrift.protocol.TField("Y", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField Z_FIELD_DESC = new org.apache.thrift.protocol.TField("Z", org.apache.thrift.protocol.TType.STRUCT, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new MInterval3StandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new MInterval3TupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable MInterval X; // required
  public @org.apache.thrift.annotation.Nullable MInterval Y; // required
  public @org.apache.thrift.annotation.Nullable MInterval Z; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    X((short)1, "X"),
    Y((short)2, "Y"),
    Z((short)3, "Z");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // X
          return X;
        case 2: // Y
          return Y;
        case 3: // Z
          return Z;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.X, new org.apache.thrift.meta_data.FieldMetaData("X", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MInterval.class)));
    tmpMap.put(_Fields.Y, new org.apache.thrift.meta_data.FieldMetaData("Y", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MInterval.class)));
    tmpMap.put(_Fields.Z, new org.apache.thrift.meta_data.FieldMetaData("Z", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MInterval.class)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MInterval3.class, metaDataMap);
  }

  public MInterval3() {
  }

  public MInterval3(
    MInterval X,
    MInterval Y,
    MInterval Z)
  {
    this();
    this.X = X;
    this.Y = Y;
    this.Z = Z;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MInterval3(MInterval3 other) {
    if (other.isSetX()) {
      this.X = new MInterval(other.X);
    }
    if (other.isSetY()) {
      this.Y = new MInterval(other.Y);
    }
    if (other.isSetZ()) {
      this.Z = new MInterval(other.Z);
    }
  }

  public MInterval3 deepCopy() {
    return new MInterval3(this);
  }

  @Override
  public void clear() {
    this.X = null;
    this.Y = null;
    this.Z = null;
  }

  @org.apache.thrift.annotation.Nullable
  public MInterval getX() {
    return this.X;
  }

  public MInterval3 setX(@org.apache.thrift.annotation.Nullable MInterval X) {
    this.X = X;
    return this;
  }

  public void unsetX() {
    this.X = null;
  }

  /** Returns true if field X is set (has been assigned a value) and false otherwise */
  public boolean isSetX() {
    return this.X != null;
  }

  public void setXIsSet(boolean value) {
    if (!value) {
      this.X = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public MInterval getY() {
    return this.Y;
  }

  public MInterval3 setY(@org.apache.thrift.annotation.Nullable MInterval Y) {
    this.Y = Y;
    return this;
  }

  public void unsetY() {
    this.Y = null;
  }

  /** Returns true if field Y is set (has been assigned a value) and false otherwise */
  public boolean isSetY() {
    return this.Y != null;
  }

  public void setYIsSet(boolean value) {
    if (!value) {
      this.Y = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public MInterval getZ() {
    return this.Z;
  }

  public MInterval3 setZ(@org.apache.thrift.annotation.Nullable MInterval Z) {
    this.Z = Z;
    return this;
  }

  public void unsetZ() {
    this.Z = null;
  }

  /** Returns true if field Z is set (has been assigned a value) and false otherwise */
  public boolean isSetZ() {
    return this.Z != null;
  }

  public void setZIsSet(boolean value) {
    if (!value) {
      this.Z = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case X:
      if (value == null) {
        unsetX();
      } else {
        setX((MInterval)value);
      }
      break;

    case Y:
      if (value == null) {
        unsetY();
      } else {
        setY((MInterval)value);
      }
      break;

    case Z:
      if (value == null) {
        unsetZ();
      } else {
        setZ((MInterval)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case X:
      return getX();

    case Y:
      return getY();

    case Z:
      return getZ();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case X:
      return isSetX();
    case Y:
      return isSetY();
    case Z:
      return isSetZ();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof MInterval3)
      return this.equals((MInterval3)that);
    return false;
  }

  public boolean equals(MInterval3 that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_X = true && this.isSetX();
    boolean that_present_X = true && that.isSetX();
    if (this_present_X || that_present_X) {
      if (!(this_present_X && that_present_X))
        return false;
      if (!this.X.equals(that.X))
        return false;
    }

    boolean this_present_Y = true && this.isSetY();
    boolean that_present_Y = true && that.isSetY();
    if (this_present_Y || that_present_Y) {
      if (!(this_present_Y && that_present_Y))
        return false;
      if (!this.Y.equals(that.Y))
        return false;
    }

    boolean this_present_Z = true && this.isSetZ();
    boolean that_present_Z = true && that.isSetZ();
    if (this_present_Z || that_present_Z) {
      if (!(this_present_Z && that_present_Z))
        return false;
      if (!this.Z.equals(that.Z))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetX()) ? 131071 : 524287);
    if (isSetX())
      hashCode = hashCode * 8191 + X.hashCode();

    hashCode = hashCode * 8191 + ((isSetY()) ? 131071 : 524287);
    if (isSetY())
      hashCode = hashCode * 8191 + Y.hashCode();

    hashCode = hashCode * 8191 + ((isSetZ()) ? 131071 : 524287);
    if (isSetZ())
      hashCode = hashCode * 8191 + Z.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(MInterval3 other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetX()).compareTo(other.isSetX());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetX()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.X, other.X);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetY()).compareTo(other.isSetY());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetY()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Y, other.Y);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetZ()).compareTo(other.isSetZ());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetZ()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Z, other.Z);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("MInterval3(");
    boolean first = true;

    sb.append("X:");
    if (this.X == null) {
      sb.append("null");
    } else {
      sb.append(this.X);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("Y:");
    if (this.Y == null) {
      sb.append("null");
    } else {
      sb.append(this.Y);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("Z:");
    if (this.Z == null) {
      sb.append("null");
    } else {
      sb.append(this.Z);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (X == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'X' was not present! Struct: " + toString());
    }
    if (Y == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'Y' was not present! Struct: " + toString());
    }
    if (Z == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'Z' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
    if (X != null) {
      X.validate();
    }
    if (Y != null) {
      Y.validate();
    }
    if (Z != null) {
      Z.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class MInterval3StandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public MInterval3StandardScheme getScheme() {
      return new MInterval3StandardScheme();
    }
  }

  private static class MInterval3StandardScheme extends org.apache.thrift.scheme.StandardScheme<MInterval3> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, MInterval3 struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // X
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.X = new MInterval();
              struct.X.read(iprot);
              struct.setXIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // Y
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.Y = new MInterval();
              struct.Y.read(iprot);
              struct.setYIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // Z
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.Z = new MInterval();
              struct.Z.read(iprot);
              struct.setZIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, MInterval3 struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.X != null) {
        oprot.writeFieldBegin(X_FIELD_DESC);
        struct.X.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.Y != null) {
        oprot.writeFieldBegin(Y_FIELD_DESC);
        struct.Y.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.Z != null) {
        oprot.writeFieldBegin(Z_FIELD_DESC);
        struct.Z.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class MInterval3TupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public MInterval3TupleScheme getScheme() {
      return new MInterval3TupleScheme();
    }
  }

  private static class MInterval3TupleScheme extends org.apache.thrift.scheme.TupleScheme<MInterval3> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, MInterval3 struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.X.write(oprot);
      struct.Y.write(oprot);
      struct.Z.write(oprot);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, MInterval3 struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.X = new MInterval();
      struct.X.read(iprot);
      struct.setXIsSet(true);
      struct.Y = new MInterval();
      struct.Y.read(iprot);
      struct.setYIsSet(true);
      struct.Z = new MInterval();
      struct.Z.read(iprot);
      struct.setZIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

