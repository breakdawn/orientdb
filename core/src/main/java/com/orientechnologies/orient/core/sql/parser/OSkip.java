/* Generated By:JJTree: Do not edit this line. OSkip.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import com.orientechnologies.orient.core.command.OCommandContext;
import com.orientechnologies.orient.core.exception.OCommandExecutionException;

import java.util.Map;

public class OSkip extends SimpleNode {

  protected OInteger num;

  protected OInputParameter inputParam;

  public OSkip(int id) {
    super(id);
  }

  public OSkip(OrientSql p, int id) {
    super(p, id);
  }

  /**
   * Accept the visitor.
   **/
  public Object jjtAccept(OrientSqlVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

  public void toString(Map<Object, Object> params, StringBuilder builder) {
    if (num == null && inputParam == null) {
      return;
    }
    builder.append(" SKIP ");
    if (num != null) {
      num.toString(params, builder);
    } else {
      inputParam.toString(params, builder);
    }
  }

  public int getValue(OCommandContext ctx) {
    if (num != null) {
      return num.getValue().intValue();
    }
    if (inputParam != null) {
      Object paramValue = inputParam.getValue(ctx.getInputParameters());
      if (paramValue instanceof Number) {
        return ((Number) paramValue).intValue();
      } else {
        throw new OCommandExecutionException("Invalid value for SKIP: " + paramValue);
      }
    }
    throw new OCommandExecutionException("No value for SKIP");
  }

  public OSkip copy() {
    OSkip result = new OSkip(-1);
    result.num = num == null ? null : num.copy();
    result.inputParam = inputParam == null ? null : inputParam.copy();
    return result;
  }

  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    OSkip oSkip = (OSkip) o;

    if (num != null ? !num.equals(oSkip.num) : oSkip.num != null)
      return false;
    if (inputParam != null ? !inputParam.equals(oSkip.inputParam) : oSkip.inputParam != null)
      return false;

    return true;
  }

  @Override public int hashCode() {
    int result = num != null ? num.hashCode() : 0;
    result = 31 * result + (inputParam != null ? inputParam.hashCode() : 0);
    return result;
  }
}
/* JavaCC - OriginalChecksum=8e13ca184705a8fc1b5939ecefe56a60 (do not edit this line) */
