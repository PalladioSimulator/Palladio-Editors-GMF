/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.helpers;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

/**
 * Edit helper to create the initial naming of the new Assembly Connector.
 * 
 * @author Benjamin Klatt
 * 
 * @generated
 */
public class AssemblyEventConnectorEditHelper extends
		PalladioComponentModelBaseEditHelper {

	/**
	 * Get the configuration command for an AssemblyConnector.
	 * 
	 * This is modified manually to create the assumed name for the new connector.
	 * 
	 * @generated not
	 */
	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {
		AssemblyEventConnector con = (AssemblyEventConnector) req
				.getElementToConfigure();
		String name = "EventConnector ";
		name += con.getSourceAssemblyContext__AssemblyEventConnector() == null ? ""
				: con.getSourceAssemblyContext__AssemblyEventConnector()
						.getEntityName();
		name += " -> ";
		name += con.getSinkAssemblyContext__AssemblyEventConnector() == null ? ""
				: con.getSinkAssemblyContext__AssemblyEventConnector()
						.getEntityName();

		ICommand cmd2 = new SetValueCommand(new SetRequest(req
				.getElementToConfigure(), EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), name));
		return cmd2;
	}
}
