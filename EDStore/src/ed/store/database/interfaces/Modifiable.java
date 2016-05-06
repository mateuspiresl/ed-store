package ed.store.database.interfaces;

import java.io.Serializable;

public interface Modifiable extends Serializable {

	public boolean wasModified();
	
}
