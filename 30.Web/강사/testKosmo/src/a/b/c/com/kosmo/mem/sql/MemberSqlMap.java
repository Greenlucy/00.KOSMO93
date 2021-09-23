package a.b.c.com.kosmo.mem.sql;

public abstract class MemberSqlMap {

	// MaxChabun 쿼리 
	public static String getMaxChabunQuery() {
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT  /*+ INDEX_DESC(A SYS_C0011199) */ 			\n");
		sb.append("         NVL(MAX(SUBSTR(A.MNUM, -4)), 0) + 1 MAXNUM	\n");
		sb.append(" FROM    MVC_MEMBER A 								\n");	  

		return sb.toString();
	}
		
	// 전체 조회
	public static String getMemberSelectAllQuery(){ 
	
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 									\n");
		sb.append("      A.MNUM 			MNUM 			\n");
		sb.append("		,A.MNAME  			MNAME 			\n");
		sb.append("		,A.MID  			MID 			\n");
	    sb.append("		,A.MPW  			MPW   			\n");
	    sb.append("		,A.MGENDER  		MGENDER 		\n");
	    sb.append("		,A.MBIRTH  			MBIRTH 			\n");
	    sb.append("		,A.MHP  			MHP 			\n");
	    sb.append("		,A.MTEL  			MTEL   			\n");	   
		sb.append("		,A.MEMAIL  			MEMAIL 			\n");		
	    sb.append("		,A.MZONECODE  		MZONECODE   	\n");
	    sb.append("		,A.MROADADDRESS  	MROADADDRESS 	\n");
	    sb.append("		,A.MGIBUNADDRESS  	MGIBUNADDRESS 	\n");
		sb.append("		,A.MHOBBY  			MHOBBY 			\n");
	    sb.append("		,A.MINFO  			MINFO   		\n");
		sb.append("		,A.MPHOTO  			MPHOTO 			\n");
	    sb.append("		,A.MADMIN  			MADMIN   		\n");
	    sb.append("		,A.DELETEYN 		DELETEYN		\n");
	    sb.append("		,TO_CHAR(A.INSERTDATE, 'YYYY-MM-DD')  INSERTDATE	\n");
	    sb.append("		,TO_CHAR(A.UPDATEDATE, 'YYYY-MM-DD')  UPDATEDATE	\n");	    
	    sb.append("	FROM 								\n");
	    sb.append("		 MVC_MEMBER A 					\n");
	    sb.append("	WHERE DELETEYN = 'Y'				\n");
	    sb.append("	ORDER BY 1 DESC						\n");

	    return sb.toString();
	}
	
	// 회원번호 조건조회
	public static String getMemberSelectQuery(){ 
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 									\n");
		sb.append("      A.MNUM 			MNUM 			\n");
		sb.append("		,A.MNAME  			MNAME 			\n");
		sb.append("		,A.MID  			MID 			\n");
	    sb.append("		,A.MPW  			MPW   			\n");
	    sb.append("		,A.MGENDER  		MGENDER 		\n");
	    sb.append("		,A.MBIRTH  			MBIRTH 			\n");
	    sb.append("		,A.MHP  			MHP 			\n");
	    sb.append("		,A.MTEL  			MTEL   			\n");	   
		sb.append("		,A.MEMAIL  			MEMAIL 			\n");		
	    sb.append("		,A.MZONECODE  		MZONECODE   	\n");
	    sb.append("		,A.MROADADDRESS  	MROADADDRESS 	\n");
	    sb.append("		,A.MGIBUNADDRESS  	MGIBUNADDRESS 	\n");
		sb.append("		,A.MHOBBY  			MHOBBY 			\n");
	    sb.append("		,A.MINFO  			MINFO   		\n");
		sb.append("		,A.MPHOTO  			MPHOTO 			\n");
	    sb.append("		,A.MADMIN  			MADMIN   		\n");
	    sb.append("		,A.DELETEYN 		DELETEYN		\n");
	    sb.append("		,TO_CHAR(A.INSERTDATE, 'YYYY-MM-DD')  INSERTDATE	\n");
	    sb.append("		,TO_CHAR(A.UPDATEDATE, 'YYYY-MM-DD')  UPDATEDATE	\n");	    
	    sb.append("	FROM 								\n");
	    sb.append("		 MVC_MEMBER A 					\n");
	    sb.append("	WHERE DELETEYN = 'Y'				\n");
	    sb.append("	AND   A.MNUM   = ?					\n");// placeholder 1

	    return sb.toString();
	}
	
	// 회원 등록
	public static String getMemberInsertQuery(){ 
		
		StringBuffer sb = new StringBuffer();			
		sb.append("	INSERT INTO 						\n");	
		sb.append("		MVC_MEMBER 				    	\n");
		sb.append("		          (			    		\n");
		sb.append("      			 MNUM 				\n"); // COLUMN 1
		sb.append("					,MNAME 				\n"); // COLUMN 2
		sb.append("					,MID 				\n"); // COLUMN 3
	    sb.append("					,MPW   				\n"); // COLUMN 4
	    sb.append("					,MGENDER 			\n"); // COLUMN 5
	    sb.append("					,MBIRTH 			\n"); // COLUMN 6
	    sb.append("					,MHP 				\n"); // COLUMN 7
	    sb.append("					,MTEL   			\n"); // COLUMN 8	   
		sb.append("					,MEMAIL 			\n"); // COLUMN 9		
	    sb.append("					,MZONECODE   		\n"); // COLUMN 10
	    sb.append("					,MROADADDRESS 		\n"); // COLUMN 11
	    sb.append("					,MGIBUNADDRESS 		\n"); // COLUMN 12
		sb.append("					,MHOBBY 			\n"); // COLUMN 13
	    sb.append("					,MINFO   			\n"); // COLUMN 14
		sb.append("					,MPHOTO 			\n"); // COLUMN 15
	    sb.append("					,MADMIN   			\n"); // COLUMN 16
	    sb.append("					,DELETEYN			\n"); // COLUMN 17
	    sb.append("					,INSERTDATE			\n"); // COLUMN 18
	    sb.append("					,UPDATEDATE			\n"); // COLUMN 19	 	  
		sb.append("			      )						\n");
		sb.append("	       VALUES   					\n");
		sb.append("	       		 (  					\n");
		sb.append("     				 ? 				\n"); // placeholder 1
		sb.append("						,? 				\n"); // placeholder 2
	    sb.append("						,?   			\n"); // placeholder 3
	    sb.append("						,?   			\n"); // placeholder 4
	    sb.append("						,? 				\n"); // placeholder 5
	    sb.append("						,? 				\n"); // placeholder 6
	    sb.append("						,?				\n"); // placeholder 7
	    sb.append("						,?				\n"); // placeholder 8
	    sb.append("						,?				\n"); // placeholder 9
	    sb.append("						,?   			\n"); // placeholder 10
	    sb.append("						,? 				\n"); // placeholder 11
	    sb.append("						,? 				\n"); // placeholder 12
	    sb.append("						,?				\n"); // placeholder 13
	    sb.append("						,?				\n"); // placeholder 14
	    sb.append("						,?				\n"); // placeholder 14
	    sb.append("						,?				\n"); // placeholder 15
	    sb.append("						,'Y'			\n"); // placeholder 16
	    sb.append("						,SYSDATE 		\n"); // placeholder 18
	    sb.append("						,SYSDATE 		\n"); // placeholder 19	
		sb.append("	              )						\n");		
		
		return sb.toString();
	}
	
	// 회원 수정
	public static String getMemberUpdateQuery(){ 
		
		StringBuffer sb = new StringBuffer();			
		sb.append("	UPDATE  							\n");	
		sb.append("		   	 MVC_MEMBER 			    \n");	
		sb.append("	SET  								\n");		
		sb.append("			 HEMAIL 		= ?			\n"); // placeholder 1	  
		sb.append("			,MZONECODE   	= ?			\n"); // placeholder 2	
		sb.append("			,MROADADDRESS 	= ?			\n"); // placeholder 3	
		sb.append("			,MGIBUNADDRESS 	= ?			\n"); // placeholder 4			   
		sb.append("			,HHOBBY 		= ? 		\n"); // placeholder 5	        	
	    sb.append("		  	,UPDATEDATE 	= SYSDATE	\n");
		sb.append("	WHERE  	 MNUM 			= ?			\n"); // placeholder 6	    
		sb.append("	AND    	 DELETEYN 		= 'Y'  		\n");		
					
		return sb.toString();
	}
	
	// 회원 삭제
	public static String getMemberDeleteQuery(){ 
		
		StringBuffer sb = new StringBuffer();			
		sb.append("	UPDATE  							\n");	
		sb.append("		   MVC_MEMBER 			    	\n");	
		sb.append("	SET  								\n");
	    sb.append("		   DELETEYN 	= 'N'			\n");	    	   
	    sb.append("		  ,UPDATEDATE 	= SYSDATE		\n");
		sb.append("	WHERE  MNUM 		= ?				\n"); // placeholder 1    
		sb.append("	AND    DELETEYN 	= 'Y'  			\n");		
					
		return sb.toString();
	}	
}
