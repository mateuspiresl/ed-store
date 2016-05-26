package ed.store.database.enums;

public enum Conditions {

	EQUAL, GREATER, SMALLER;
	
	public boolean check(int compareResult)
	{
		switch (this)
		{
		case EQUAL:		return compareResult == 0;
		case GREATER:	return compareResult > 0;
		case SMALLER:	return compareResult < 0;
		default:		return false;
		}
	}

}