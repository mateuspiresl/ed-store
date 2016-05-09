package ed.store.database.interfaces;

import java.io.Serializable;

/**	Essa interface serve para notificar e verificar se algum
 * 		dado foi modificado e permitir a persistência.
 * 
 * @author Mateus Pires
 */
public interface Modifiable extends Serializable {

	public boolean wasModified();
	public void notifyModification();
	public void notifySaving();
	
}
