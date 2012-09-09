/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.policies;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;

/**
 * @generated
 */
public class RequiredRoleItemSemanticEditPolicy extends PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public RequiredRoleItemSemanticEditPolicy() {
        // TODO: Model changed
        // super(PalladioComponentModelElementTypes.RequiredRole_3010);
        super(PalladioComponentModelElementTypes.OperationProvidedRole_3011);

    }

    /**
     * @generated
     */
    protected Command getDestroyElementCommand(DestroyElementRequest req) {
        View view = (View) getHost().getModel();
        CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
        cmd.setTransactionNestingEnabled(false);
        EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
        if (annotation == null) {
            // there are indirectly referenced children, need extra commands: false
            addDestroyShortcutsCommand(cmd, view);
            // delete host element
            cmd.add(new DestroyElementCommand(req));
        } else {
            cmd.add(new DeleteCommand(getEditingDomain(), view));
        }
        return getGEFWrapper(cmd.reduce());
    }

    // TODO: write javadoc and annotations
    /**
     * @generated not
     */
    protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
        if (PalladioComponentModelElementTypes.AssemblyConnector_4004 == req.getElementType()) {
            return req.getTarget() == null ? getCreateStartOutgoingAssemblyConnector_4001Command(req) : null;
        }
        if (PalladioComponentModelElementTypes.RequiredDelegationConnector_4005 == req.getElementType()) {
            return req.getTarget() == null ? getCreateStartOutgoingRequiredDelegationConnector_4002Command(req) : null;
        }
        return super.getCreateRelationshipCommand(req);
    }

    // TODO: write javadoc and annotations
    /**
     * @generated not
     */
    protected Command getCreateStartOutgoingAssemblyConnector_4001Command(CreateRelationshipRequest req) {
        EObject sourceEObject = req.getSource();
        if (false == sourceEObject instanceof OperationRequiredRole) {
            return UnexecutableCommand.INSTANCE;
        }
        OperationRequiredRole source = (OperationRequiredRole) sourceEObject;
        ComposedStructure container = (ComposedStructure) getRelationshipContainer(source,
                CompositionPackage.eINSTANCE.getComposedStructure(), req.getElementType());
        if (container == null) {
            return UnexecutableCommand.INSTANCE;
        }
        if (!PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints.canCreateAssemblyConnector_4004(
                container, source, null)) {
            return UnexecutableCommand.INSTANCE;
        }
        req.setParameter("REQ_CHILD_CONTEXT", ((View) getHost().getParent().getModel()).getElement());
        return new Command() {
        };
    }

    // TODO: write javadoc and annotations
    /**
     * @generated not
     */
    protected Command getCreateStartOutgoingRequiredDelegationConnector_4002Command(CreateRelationshipRequest req) {
        EObject sourceEObject = req.getSource();
        if (false == sourceEObject instanceof OperationRequiredRole) {
            return UnexecutableCommand.INSTANCE;
        }
        OperationRequiredRole source = (OperationRequiredRole) sourceEObject;
        ComposedStructure container = (ComposedStructure) getRelationshipContainer(source,
                CompositionPackage.eINSTANCE.getComposedStructure(), req.getElementType());
        if (container == null) {
            return UnexecutableCommand.INSTANCE;
        }
        req.setParameter("CHILD_CONTEXT", ((View) getHost().getParent().getModel()).getElement());
        if (!PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
                .canCreateRequiredDelegationConnector_4005(container, source, null)) {
            return UnexecutableCommand.INSTANCE;
        }
        return new Command() {
        };
    }

}
