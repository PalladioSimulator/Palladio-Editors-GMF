package de.uka.ipd.sdq.pcm.dialogs.parameters;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ItemProviderDecorator;

import de.uka.ipd.sdq.pcm.dialogs.datatype.ParameterRepresentation;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.Signature;

/**
 * This class is a decorator for the generated EMF.Edit item providers. It
 * provides item providers which are used in the operations tab of the tabbed
 * properties sheet when editing interfaces. It implements
 * ITableItemLabelProvider to display the given EObject in a tabular form.
 * Additionally it provided the labels by partcial delegation to the original
 * IItemLabelProvider.
 * 
 * @author Roman Andrej
 */
public class ParametersItemProvider extends ItemProviderDecorator implements
		ITableItemLabelProvider, IItemLabelProvider {

	/**
	 * Inherited default constructor
	 * 
	 * @param factory
	 *            The factory which created this object
	 */
	public ParametersItemProvider(AdapterFactory adapterFactory){
		super(adapterFactory);
	}

	/**
	 * @see org.eclipse.emf.edit.provider.ItemProviderDecorator#getColumnImage(java.lang.Object,
	 *      int) Get the icon by delegation if the first column is displayed
	 */
	@Override
	public Object getColumnImage(Object object, int columnIndex) {
		if (columnIndex == CreateEditorContents.ICON_COLUMN_INDEX)
			return this.getImage(object);
		return null;
	}

	/**
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object,
	 *      int) Format the columns with the given index constant as string text
	 *      for displaying
	 */
	@Override
	public String getColumnText(Object element, int columnIndex) {
		String result = "";
		Parameter parameter = (Parameter) element;

		switch (columnIndex) {
		case CreateEditorContents.ICON_COLUMN_INDEX:
			break;
		case CreateEditorContents.CONTEXT_COLUMN_INDEX:
			result = ((Signature) parameter.eContainer()).getEntityName();
			break;
		case CreateEditorContents.NAME_COLUMN_INDEX:
			if (parameter.getParameterName() != null)
				result = parameter.getParameterName();
			else
				result = "null";
			break;
		case CreateEditorContents.TYPE_COLUMN_INDEX:
			result = ParameterRepresentation.dataTypeToString(parameter
					.getDataType__Parameter());
			break;
		default:
			break;
		}
		return result;
	}
}
