package ed.store.database.interfaces;

import java.io.Serializable;

/**	Essa interface serve para notificar e verificar se algum
 * 		dado foi modificado e permitir a persistência. */
public interface Modifiable {

	public boolean wasModified();
	public void notifyChanges();
	public void notifySaving();
	
}
