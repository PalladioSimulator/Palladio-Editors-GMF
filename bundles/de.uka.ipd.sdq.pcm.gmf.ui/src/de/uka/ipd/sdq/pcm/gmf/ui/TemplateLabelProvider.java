package de.uka.ipd.sdq.pcm.gmf.ui;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;

/**
 * A label provider for the Palladio templates.
 * @author Benjamin Klatt
 *
 */
public class TemplateLabelProvider extends LabelProvider implements
		IBaseLabelProvider {

	@Override
	public String getText(Object element) {
		if(element instanceof PalladioTemplate){
			return ((PalladioTemplate) element).getName();
		}
		return super.getText(element);
	}
}
