/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;

/**
 * The Class AssemblyConnectorTypeLinkCreateCommand.
 *
 * @generated
 */
public class AssemblyConnectorTypeLinkCreateCommand extends CreateRelationshipCommand {

    /** The my container. @generated */
    private ComposedStructure myContainer;

    /** The my source. @generated */
    private OperationRequiredRole mySource;

    /** The my target. @generated */
    private OperationProvidedRole myTarget;

    /**
     * Instantiates a new assembly connector type link create command.
     *
     * @param req the req
     * @param container the container
     * @param source the source
     * @param target the target
     * @generated
     */
    public AssemblyConnectorTypeLinkCreateCommand(CreateRelationshipRequest req, ComposedStructure container,
            OperationRequiredRole source, OperationProvidedRole target) {
        super(req);
        super.setElementToEdit(container);
        myContainer = container;
        mySource = source;
        myTarget = target;
    }

    /**
     * Gets the container.
     *
     * @return the container
     * @generated
     */
    public ComposedStructure getContainer() {
        return myContainer;
    }

    /**
     * Gets the source.
     *
     * @return the source
     * @generated
     */
    public EObject getSource() {
        return mySource;
    }

    /**
     * Gets the target.
     *
     * @return the target
     * @generated
     */
    public EObject getTarget() {
        return myTarget;
    }

    /**
     * Gets the e class to edit.
     *
     * @return the e class to edit
     * @generated
     */
    protected EClass getEClassToEdit() {
        return CompositionPackage.eINSTANCE.getComposedStructure();
    }

    /**
     * Sets the element to edit.
     *
     * @param element the new element to edit
     * @generated
     */
    protected void setElementToEdit(EObject element) {
        throw new UnsupportedOperationException();
    }

    /**
     * Do default element creation.
     *
     * @return the e object
     * @generated not
     */
    protected EObject doDefaultElementCreation() {
        AssemblyConnector newElement = (AssemblyConnector) super.doDefaultElementCreation();
        if (newElement != null) {
            newElement.setProvidedRole_AssemblyConnector(myTarget);
            newElement.setRequiredRole_AssemblyConnector(mySource);
            CreateRelationshipRequest req = (CreateRelationshipRequest) this.getRequest();
            newElement.setRequiringAssemblyContext_AssemblyConnector((AssemblyContext) req
                    .getParameter("REQ_CHILD_CONTEXT"));
            newElement.setProvidingAssemblyContext_AssemblyConnector((AssemblyContext) req
                    .getParameter("PROV_CHILD_CONTEXT"));
        }
        return newElement;
    }

}
