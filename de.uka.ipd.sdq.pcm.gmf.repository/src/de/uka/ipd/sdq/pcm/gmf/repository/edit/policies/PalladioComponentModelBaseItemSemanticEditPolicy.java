/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.helpers.PalladioComponentModelBaseEditHelper;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.repository.CompleteComponentType;
import de.uka.ipd.sdq.pcm.repository.EventGroup;
import de.uka.ipd.sdq.pcm.repository.ImplementationComponentType;
import de.uka.ipd.sdq.pcm.repository.InfrastructureInterface;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;

/**
 * @generated
 */
public class PalladioComponentModelBaseItemSemanticEditPolicy extends SemanticEditPolicy {

    /**
     * Extended request data key to hold editpart visual id.
     * 
     * @generated
     */
    public static final String VISUAL_ID_KEY = "visual_id"; //$NON-NLS-1$

    /**
     * @generated
     */
    private final IElementType myElementType;

    /**
     * @generated
     */
    protected PalladioComponentModelBaseItemSemanticEditPolicy(IElementType elementType) {
        myElementType = elementType;
    }

    /**
     * Add visual id of edited editpart to extended data of the request so command switch can decide
     * what kind of diagram element is being edited. It is done in those cases when it's not
     * possible to deduce diagram element kind from domain element.
     * 
     * @generated
     */
    public Command getCommand(Request request) {
        if (request instanceof ReconnectRequest) {
            Object view = ((ReconnectRequest) request).getConnectionEditPart().getModel();
            if (view instanceof View) {
                Integer id = new Integer(PalladioComponentModelVisualIDRegistry.getVisualID((View) view));
                request.getExtendedData().put(VISUAL_ID_KEY, id);
            }
        }
        return super.getCommand(request);
    }

    /**
     * Returns visual id from request parameters.
     * 
     * @generated
     */
    protected int getVisualID(IEditCommandRequest request) {
        Object id = request.getParameter(VISUAL_ID_KEY);
        return id instanceof Integer ? ((Integer) id).intValue() : -1;
    }

    /**
     * @generated
     */
    protected Command getSemanticCommand(IEditCommandRequest request) {
        IEditCommandRequest completedRequest = completeRequest(request);
        Command semanticCommand = getSemanticCommandSwitch(completedRequest);
        semanticCommand = getEditHelperCommand(completedRequest, semanticCommand);
        if (completedRequest instanceof DestroyRequest) {
            DestroyRequest destroyRequest = (DestroyRequest) completedRequest;
            return shouldProceed(destroyRequest) ? addDeleteViewCommand(semanticCommand, destroyRequest) : null;
        }
        return semanticCommand;
    }

    /**
     * @generated
     */
    protected Command addDeleteViewCommand(Command mainCommand, DestroyRequest completedRequest) {
        Command deleteViewCommand = getGEFWrapper(new DeleteCommand(getEditingDomain(), (View) getHost().getModel()));
        return mainCommand == null ? deleteViewCommand : mainCommand.chain(deleteViewCommand);
    }

    /**
     * @generated
     */
    private Command getEditHelperCommand(IEditCommandRequest request, Command editPolicyCommand) {
        if (editPolicyCommand != null) {
            ICommand command = editPolicyCommand instanceof ICommandProxy ? ((ICommandProxy) editPolicyCommand)
                    .getICommand() : new CommandProxy(editPolicyCommand);
            request.setParameter(PalladioComponentModelBaseEditHelper.EDIT_POLICY_COMMAND, command);
        }
        IElementType requestContextElementType = getContextElementType(request);
        request.setParameter(PalladioComponentModelBaseEditHelper.CONTEXT_ELEMENT_TYPE, requestContextElementType);
        ICommand command = requestContextElementType.getEditCommand(request);
        request.setParameter(PalladioComponentModelBaseEditHelper.EDIT_POLICY_COMMAND, null);
        request.setParameter(PalladioComponentModelBaseEditHelper.CONTEXT_ELEMENT_TYPE, null);
        if (command != null) {
            if (!(command instanceof CompositeTransactionalCommand)) {
                command = new CompositeTransactionalCommand(getEditingDomain(), command.getLabel()).compose(command);
            }
            return new ICommandProxy(command);
        }
        return editPolicyCommand;
    }

    /**
     * @generated
     */
    private IElementType getContextElementType(IEditCommandRequest request) {
        IElementType requestContextElementType = PalladioComponentModelElementTypes
                .getElementType(getVisualID(request));
        return requestContextElementType != null ? requestContextElementType : myElementType;
    }

    /**
     * @generated
     */
    protected Command getSemanticCommandSwitch(IEditCommandRequest req) {
        if (req instanceof CreateRelationshipRequest) {
            return getCreateRelationshipCommand((CreateRelationshipRequest) req);
        } else if (req instanceof CreateElementRequest) {
            return getCreateCommand((CreateElementRequest) req);
        } else if (req instanceof ConfigureRequest) {
            return getConfigureCommand((ConfigureRequest) req);
        } else if (req instanceof DestroyElementRequest) {
            return getDestroyElementCommand((DestroyElementRequest) req);
        } else if (req instanceof DestroyReferenceRequest) {
            return getDestroyReferenceCommand((DestroyReferenceRequest) req);
        } else if (req instanceof DuplicateElementsRequest) {
            return getDuplicateCommand((DuplicateElementsRequest) req);
        } else if (req instanceof GetEditContextRequest) {
            return getEditContextCommand((GetEditContextRequest) req);
        } else if (req instanceof MoveRequest) {
            return getMoveCommand((MoveRequest) req);
        } else if (req instanceof ReorientReferenceRelationshipRequest) {
            return getReorientReferenceRelationshipCommand((ReorientReferenceRelationshipRequest) req);
        } else if (req instanceof ReorientRelationshipRequest) {
            return getReorientRelationshipCommand((ReorientRelationshipRequest) req);
        } else if (req instanceof SetRequest) {
            return getSetCommand((SetRequest) req);
        }
        return null;
    }

    /**
     * @generated
     */
    protected Command getConfigureCommand(ConfigureRequest req) {
        return null;
    }

    /**
     * @generated
     */
    protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
        return null;
    }

    /**
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        return null;
    }

    /**
     * @generated
     */
    protected Command getSetCommand(SetRequest req) {
        return null;
    }

    /**
     * @generated
     */
    protected Command getEditContextCommand(GetEditContextRequest req) {
        return null;
    }

    /**
     * @generated
     */
    protected Command getDestroyElementCommand(DestroyElementRequest req) {
        return null;
    }

    /**
     * @generated
     */
    protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
        return null;
    }

    /**
     * @generated
     */
    protected Command getDuplicateCommand(DuplicateElementsRequest req) {
        return null;
    }

    /**
     * @generated
     */
    protected Command getMoveCommand(MoveRequest req) {
        return null;
    }

    /**
     * @generated
     */
    protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
        return UnexecutableCommand.INSTANCE;
    }

    /**
     * @generated
     */
    protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
        return UnexecutableCommand.INSTANCE;
    }

    /**
     * @generated
     */
    protected final Command getGEFWrapper(ICommand cmd) {
        return new ICommandProxy(cmd);
    }

    /**
     * Returns editing domain from the host edit part.
     * 
     * @generated
     */
    protected TransactionalEditingDomain getEditingDomain() {
        return ((IGraphicalEditPart) getHost()).getEditingDomain();
    }

    /**
     * Clean all shortcuts to the host element from the same diagram
     * 
     * @generated
     */
    protected void addDestroyShortcutsCommand(ICompositeCommand cmd, View view) {
        assert view.getEAnnotation("Shortcut") == null; //$NON-NLS-1$
        for (Iterator it = view.getDiagram().getChildren().iterator(); it.hasNext();) {
            View nextView = (View) it.next();
            if (nextView.getEAnnotation("Shortcut") == null || !nextView.isSetElement() || nextView.getElement() != view.getElement()) { //$NON-NLS-1$
                continue;
            }
            cmd.add(new DeleteCommand(getEditingDomain(), nextView));
        }
    }

    /**
     * @generated
     */
    public static class LinkConstraints {

        /**
         * @generated
         */
        public static boolean canCreateOperationProvidedRole_4105(InterfaceProvidingEntity source,
                OperationInterface target) {
            return canExistOperationProvidedRole_4105(source, target);
        }

        /**
         * @generated
         */
        public static boolean canCreateInfrastructureProvidedRole_4111(InterfaceProvidingEntity source,
                InfrastructureInterface target) {
            return canExistInfrastructureProvidedRole_4111(source, target);
        }

        /**
         * @generated
         */
        public static boolean canCreateInfrastructureRequiredRole_4112(InterfaceRequiringEntity source,
                InfrastructureInterface target) {
            return canExistInfrastructureRequiredRole_4112(source, target);
        }

        /**
         * @generated
         */
        public static boolean canCreateSinkRole_4109(InterfaceProvidingEntity source, EventGroup target) {
            return canExistSinkRole_4109(source, target);
        }

        /**
         * @generated
         */
        public static boolean canCreateOperationRequiredRole_4106(InterfaceRequiringEntity source,
                OperationInterface target) {
            return canExistOperationRequiredRole_4106(source, target);
        }

        /**
         * @generated
         */
        public static boolean canCreateImplementationComponentTypeParentCompleteComponentTypes_4103(
                ImplementationComponentType source, CompleteComponentType target) {
            if (source != null) {
                if (source.getParentCompleteComponentTypes().contains(target)) {
                    return false;
                }
            }

            return canExistImplementationComponentTypeParentCompleteComponentTypes_4103(source, target);
        }

        /**
         * @generated
         */
        public static boolean canCreateCompleteComponentTypeParentProvidesComponentTypes_4104(
                CompleteComponentType source, ProvidesComponentType target) {
            if (source != null) {
                if (source.getParentProvidesComponentTypes().contains(target)) {
                    return false;
                }
            }

            return canExistCompleteComponentTypeParentProvidesComponentTypes_4104(source, target);
        }

        /**
         * @generated
         */
        public static boolean canCreateSourceRole_4110(InterfaceRequiringEntity source, EventGroup target) {
            return canExistSourceRole_4110(source, target);
        }

        /**
         * @generated
         */
        public static boolean canExistOperationProvidedRole_4105(InterfaceProvidingEntity source,
                OperationInterface target) {
            return true;
        }

        /**
         * @generated
         */
        public static boolean canExistInfrastructureProvidedRole_4111(InterfaceProvidingEntity source,
                InfrastructureInterface target) {
            return true;
        }

        /**
         * @generated
         */
        public static boolean canExistInfrastructureRequiredRole_4112(InterfaceRequiringEntity source,
                InfrastructureInterface target) {
            return true;
        }

        /**
         * @generated
         */
        public static boolean canExistSinkRole_4109(InterfaceProvidingEntity source, EventGroup target) {
            return true;
        }

        /**
         * @generated
         */
        public static boolean canExistOperationRequiredRole_4106(InterfaceRequiringEntity source,
                OperationInterface target) {
            return true;
        }

        /**
         * @generated
         */
        public static boolean canExistImplementationComponentTypeParentCompleteComponentTypes_4103(
                ImplementationComponentType source, CompleteComponentType target) {
            return true;
        }

        /**
         * @generated
         */
        public static boolean canExistCompleteComponentTypeParentProvidesComponentTypes_4104(
                CompleteComponentType source, ProvidesComponentType target) {
            return true;
        }

        /**
         * @generated
         */
        public static boolean canExistSourceRole_4110(InterfaceRequiringEntity source, EventGroup target) {
            return true;
        }

    }

}
