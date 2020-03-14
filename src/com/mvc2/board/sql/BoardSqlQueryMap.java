package com.mvc2.board.sql;

public abstract class BoardSqlQueryMap {
public static final String BOARD_KNO_CHAEBUN = "SELECT NVL(MAX(SUBSTR((A.KNO), -3)), 0) + 1 COMNO FROM KBOARD_MVC2 A";
	
	public static String getInsertQuery(){
		
		StringBuffer sb = new StringBuffer();
		sb.append(" INSERT INTO													    \n");
		sb.append(" KBOARD_MVC2	(												    \n");
		sb.append("					KNO												\n");
		sb.append("				   ,KTITLE											\n");
		sb.append("				   ,KNAME											\n");
		sb.append("				   ,KPW												\n");
		sb.append("				   ,KCONTENT										\n");
		sb.append("				   ,KIMG											\n");
		sb.append("				   ,KDELETEYN										\n");
		sb.append("				   ,KINSERTDATE										\n");
		sb.append(" 			   ,KUPDATEDATE										\n");
		sb.append("					)												\n");
		sb.append(" VALUES			(												\n");
		sb.append("				    ?												\n");
		sb.append("	  			   ,?												\n");
		sb.append("				   ,?												\n");
		sb.append("				   ,?												\n");
		sb.append("				   ,?												\n");
		sb.append("				   ,?												\n");
		sb.append("				   ,'Y'												\n");
		sb.append("			       ,SYSDATE											\n");
		sb.append("				   ,SYSDATE											\n");
		sb.append("					)												\n");
		return sb.toString();
	} 
	
	public static String getSelectQuery() {
		
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT															\n");
		sb.append("  A.KNO KNO														\n");
		sb.append(" ,A.KTITLE KTITLE 												\n");
		sb.append("	,A.KNAME KNAME 													\n");
		sb.append("	,A.KPW KPW 														\n");
		sb.append("	,A.KCONTENT KCONTENT 											\n");
		sb.append("	,A.KIMG KIMG		 											\n");
		sb.append(" ,A.KDELETEYN KDELETEYN 											\n");
		sb.append("	,A.KINSERTDATE KINSERTDATE 										\n");
		sb.append(" ,A.KUPDATEDATE KUPDATEDATE 										\n");
		sb.append(" FROM 															\n");
		sb.append(" 	KBOARD_MVC2 A												\n");
		sb.append(" WHERE  1=1 														\n");
		sb.append(" AND A.KDELETEYN = 'Y' 											\n");
		sb.append(" ORDER BY 1														\n");
		return sb.toString();
		
	}
	
	public static String getUpdateQuery() {
		
		StringBuffer sb = new StringBuffer();
		sb.append(" UPDATE																\n");
		sb.append(" KBOARD_MVC2 A														\n");
		sb.append(" SET																	\n");
		sb.append("       A.KTITLE = ? 				 									\n");
		sb.append("      ,A.KNAME = ? 													\n");
		sb.append("      ,A.KCONTENT = ? 												\n");
		sb.append("      ,A.KIMG = ? 													\n");
		sb.append("      ,A.KUPDATEDATE = SYSDATE								 		\n");
		sb.append(" WHERE A.KNO = ? 													\n");	
		sb.append(" AND   A.KDELETEYN = 'Y' 											\n");
		return sb.toString();
	}
	
	public static String getSearchQuery(){
		
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT 												\n");
		sb.append("  A.KTITLE KTITLE									\n");
		sb.append(" ,A.KNO KNO											\n");
		sb.append(" ,A.KNAME KNAME 										\n");
		sb.append(" ,A.KPW KPW 											\n");
		sb.append(" ,A.KCONTENT KCONTENT 								\n");
		sb.append("	,A.KIMG KIMG		 								\n");
		sb.append(" ,A.KDELETEYN KDELETEYN 								\n");
		sb.append(" ,TO_CHAR(A.KINSERTDATE, 'YYYY-MM-DD') KINSERTDATE 	\n");
		sb.append(" ,TO_CHAR(A.KUPDATEDATE, 'YYYY-MM-DD') KUPDATEDATE 	\n");
		sb.append(" FROM   												\n");
		sb.append("    	KBOARD_MVC2 A 									\n");
		sb.append(" WHERE A.KNO = ? 									\n");
		return sb.toString();
	}
	
	public static String getDeleteQuery(){
		StringBuffer sb = new StringBuffer();
		sb.append(" UPDATE														\n");
		sb.append(" KBOARD_MVC2 A									 				\n");
		sb.append(" SET															\n");
		sb.append("       A.KDELETEYN = 'N' 										\n");
		sb.append("		 ,A.KUPDATEDATE = SYSDATE									\n");
		sb.append(" WHERE A.KNO = ? 												\n");	
		sb.append(" AND   A.KDELETEYN = 'Y' 										\n");
		return sb.toString();
		
	}
	
}
