
	PROC LDRAGON ( LEVEL )
	    IF LEVEL == 0 THEN
		FORWARD 5 
	    ELSE
		LDRAGON ( LEVEL - 1 )
		LEFT 90
		RDRAGON ( LEVEL - 1 )
	    ENDIF

hello world

	    

	PROC RDRAGON ( LEVEL )
	    IF LEVEL == 0 THEN
		FORWARD 5 
	    ELSE
		LDRAGON ( LEVEL - 1 ) 
		RIGHT 90
		RDRAGON ( LEVEL - 1 )
	    ENDIF 

	PROC MAIN (VOID)
	   LDRAGON ( 11 )
