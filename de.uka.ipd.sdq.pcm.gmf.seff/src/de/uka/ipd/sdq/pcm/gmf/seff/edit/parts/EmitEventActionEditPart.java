/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.EmitEventActionItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * The Class EmitEventActionEditPart.
 *
 * @generated
 */
public class EmitEventActionEditPart extends ShapeNodeEditPart {

    /** The Constant VISUAL_ID. @generated */
    public static final int VISUAL_ID = 2013;

    /** The content pane. @generated */
    protected IFigure contentPane;

    /** The primary shape. @generated */
    protected IFigure primaryShape;

    /**
     * Instantiates a new emit event action edit part.
     *
     * @param view the view
     * @generated
     */
    public EmitEventActionEditPart(View view) {
        super(view);
    }

    /**
     * Creates the default edit policies.
     *
     * @generated
     */
    protected void createDefaultEditPolicies() {
        installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new EmitEventActionItemSemanticEditPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
        // XXX need an SCR to runtime to have another abstract superclass that would let children
        // add reasonable editpolicies
        // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
    }

    /**
     * Creates the layout edit policy.
     *
     * @return the layout edit policy
     * @generated
     */
    protected LayoutEditPolicy createLayoutEditPolicy() {
        LayoutEditPolicy lep = new LayoutEditPolicy() {

            protected EditPolicy createChildEditPolicy(EditPart child) {
                EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
                if (result == null) {
                    result = new NonResizableEditPolicy();
                }
                return result;
            }

            protected Command getMoveChildrenCommand(Request request) {
                return null;
            }

            protected Command getCreateCommand(CreateRequest request) {
                return null;
            }
        };
        return lep;
    }

    /**
     * Creates the node shape.
     *
     * @return the i figure
     * @generated
     */
    protected IFigure createNodeShape() {
        EmitEventActionFigure figure = new EmitEventActionFigure();
        return primaryShape = figure;
    }

    /**
     * Gets the primary shape.
     *
     * @return the primary shape
     * @generated
     */
    public EmitEventActionFigure getPrimaryShape() {
        return (EmitEventActionFigure) primaryShape;
    }

    /**
     * Adds the fixed child.
     *
     * @param childEditPart the child edit part
     * @return true, if successful
     * @generated
     */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof EmitEventActionEntityNameEditPart) {
            ((EmitEventActionEntityNameEditPart) childEditPart).setLabel(getPrimaryShape()
                    .getFigureComponentEmitEventAction());
            return true;
        }
        if (childEditPart instanceof EmitEventActionInputVariableUsageEventEditPart) {
            IFigure pane = getPrimaryShape().getFigureEmitEventActionCompartmentRectangle();
            setupContentPane(pane); // FIXME each comparment should handle his content pane in his
                                    // own way
            pane.add(((EmitEventActionInputVariableUsageEventEditPart) childEditPart).getFigure());
            return true;
        }
        return false;
    }

    /**
     * Removes the fixed child.
     *
     * @param childEditPart the child edit part
     * @return true, if successful
     * @generated
     */
    protected boolean removeFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof EmitEventActionEntityNameEditPart) {
            return true;
        }
        if (childEditPart instanceof EmitEventActionInputVariableUsageEventEditPart) {
            IFigure pane = getPrimaryShape().getFigureEmitEventActionCompartmentRectangle();
            setupContentPane(pane); // FIXME each comparment should handle his content pane in his
                                    // own way
            pane.remove(((EmitEventActionInputVariableUsageEventEditPart) childEditPart).getFigure());
            return true;
        }
        return false;
    }

    /**
     * Adds the child visual.
     *
     * @param childEditPart the child edit part
     * @param index the index
     * @generated
     */
    protected void addChildVisual(EditPart childEditPart, int index) {
        if (addFixedChild(childEditPart)) {
            return;
        }
        super.addChildVisual(childEditPart, -1);
    }

    /**
     * Removes the child visual.
     *
     * @param childEditPart the child edit part
     * @generated
     */
    protected void removeChildVisual(EditPart childEditPart) {
        if (removeFixedChild(childEditPart)) {
            return;
        }
        super.removeChildVisual(childEditPart);
    }

    /**
     * Gets the content pane for.
     *
     * @param editPart the edit part
     * @return the content pane for
     * @generated
     */
    protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
        if (editPart instanceof EmitEventActionInputVariableUsageEventEditPart) {
            return getPrimaryShape().getFigureEmitEventActionCompartmentRectangle();
        }
        return getContentPane();
    }

    /**
     * Creates the node plate.
     *
     * @return the node figure
     * @generated
     */
    protected NodeFigure createNodePlate() {
        DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
        return result;
    }

    /**
     * Creates figure for this edit part.
     * 
     * Body of this method does not depend on settings in generation model so you may safely remove
     * <i>generated</i> tag and modify it.
     *
     * @return the node figure
     * @generated
     */
    protected NodeFigure createNodeFigure() {
        NodeFigure figure = createNodePlate();
        figure.setLayoutManager(new StackLayout());
        IFigure shape = createNodeShape();
        figure.add(shape);
        contentPane = setupContentPane(shape);
        return figure;
    }

    /**
     * Default implementation treats passed figure as content pane. Respects layout one may have set
     * for generated figure.
     *
     * @param nodeShape instance of generated figure class
     * @return the i figure
     * @generated
     */
    protected IFigure setupContentPane(IFigure nodeShape) {
        if (nodeShape.getLayoutManager() == null) {
            ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
            layout.setSpacing(5);
            nodeShape.setLayoutManager(layout);
        }
        return nodeShape; // use nodeShape itself as contentPane
    }

    /**
     * Gets the content pane.
     *
     * @return the content pane
     * @generated
     */
    public IFigure getContentPane() {
        if (contentPane != null) {
            return contentPane;
        }
        return super.getContentPane();
    }

    /**
     * Sets the foreground color.
     *
     * @param color the new foreground color
     * @generated
     */
    protected void setForegroundColor(Color color) {
        if (primaryShape != null) {
            primaryShape.setForegroundColor(color);
        }
    }

    /**
     * Sets the background color.
     *
     * @param color the new background color
     * @generated
     */
    protected void setBackgroundColor(Color color) {
        if (primaryShape != null) {
            primaryShape.setBackgroundColor(color);
        }
    }

    /**
     * Sets the line width.
     *
     * @param width the new line width
     * @generated
     */
    protected void setLineWidth(int width) {
        if (primaryShape instanceof Shape) {
            ((Shape) primaryShape).setLineWidth(width);
        }
    }

    /**
     * Sets the line type.
     *
     * @param style the new line type
     * @generated
     */
    protected void setLineType(int style) {
        if (primaryShape instanceof Shape) {
            ((Shape) primaryShape).setLineStyle(style);
        }
    }

    /**
     * Gets the primary child edit part.
     *
     * @return the primary child edit part
     * @generated
     */
    public EditPart getPrimaryChildEditPart() {
        return getChildBySemanticHint(PalladioComponentModelVisualIDRegistry
                .getType(EmitEventActionEntityNameEditPart.VISUAL_ID));
    }

    /**
     * Gets the mA rel types on source.
     *
     * @return the mA rel types on source
     * @generated
     */
    public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnSource() {
        List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
                                                                                            * <org.
                                                                                            * eclipse
                                                                                            * .gmf.
                                                                                            * runtime
                                                                                            * .
                                                                                            * emf.type
                                                                                            * .core.
                                                                                            * IElementType
                                                                                            * >
                                                                                            */();
        types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        return types;
    }

    /**
     * Gets the mA rel types on source and target.
     *
     * @param targetEditPart the target edit part
     * @return the mA rel types on source and target
     * @generated
     */
    public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnSourceAndTarget(
            IGraphicalEditPart targetEditPart) {
        List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
                                                                                            * <org.
                                                                                            * eclipse
                                                                                            * .gmf.
                                                                                            * runtime
                                                                                            * .
                                                                                            * emf.type
                                                                                            * .core.
                                                                                            * IElementType
                                                                                            * >
                                                                                            */();
        if (targetEditPart instanceof StartActionEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof StopActionEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof ExternalCallActionEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.EmitEventActionEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof LoopActionEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof BranchActionEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof InternalActionEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof CollectionIteratorActionEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof SetVariableActionEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof AcquireActionEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof ReleaseActionEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof ForkActionEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof RecoveryActionEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof StartAction2EditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof StopAction2EditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof LoopAction2EditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof InternalAction2EditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof BranchAction2EditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof ExternalCallAction2EditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof EmitEventAction2EditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof AcquireAction2EditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof ReleaseAction2EditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof ForkAction2EditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof CollectionIteratorAction2EditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof RecoveryAction2EditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        if (targetEditPart instanceof SetVariableAction2EditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        }
        return types;
    }

    /**
     * Gets the mA types for target.
     *
     * @param relationshipType the relationship type
     * @return the mA types for target
     * @generated
     */
    public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMATypesForTarget(
            IElementType relationshipType) {
        List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
                                                                                            * <org.
                                                                                            * eclipse
                                                                                            * .gmf.
                                                                                            * runtime
                                                                                            * .
                                                                                            * emf.type
                                                                                            * .core.
                                                                                            * IElementType
                                                                                            * >
                                                                                            */();
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.StartAction_2001);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.StopAction_2002);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.ExternalCallAction_2003);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.EmitEventAction_2013);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.LoopAction_2004);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.BranchAction_2005);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.InternalAction_2006);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.CollectionIteratorAction_2007);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.SetVariableAction_2008);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.AcquireAction_2012);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.ReleaseAction_2010);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.ForkAction_2011);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.RecoveryAction_2016);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.StartAction_3004);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.StopAction_3005);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.LoopAction_3006);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.InternalAction_3007);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.BranchAction_3009);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.ExternalCallAction_3012);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.EmitEventAction_3046);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.AcquireAction_3026);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.ReleaseAction_3020);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.ForkAction_3023);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.CollectionIteratorAction_3013);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.RecoveryAction_3057);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.SetVariableAction_3024);
        }
        return types;
    }

    /**
     * Gets the mA rel types on target.
     *
     * @return the mA rel types on target
     * @generated
     */
    public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnTarget() {
        List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
                                                                                            * <org.
                                                                                            * eclipse
                                                                                            * .gmf.
                                                                                            * runtime
                                                                                            * .
                                                                                            * emf.type
                                                                                            * .core.
                                                                                            * IElementType
                                                                                            * >
                                                                                            */();
        types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
        return types;
    }

    /**
     * Gets the mA types for source.
     *
     * @param relationshipType the relationship type
     * @return the mA types for source
     * @generated
     */
    public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMATypesForSource(
            IElementType relationshipType) {
        List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
                                                                                            * <org.
                                                                                            * eclipse
                                                                                            * .gmf.
                                                                                            * runtime
                                                                                            * .
                                                                                            * emf.type
                                                                                            * .core.
                                                                                            * IElementType
                                                                                            * >
                                                                                            */();
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.StartAction_2001);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.StopAction_2002);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.ExternalCallAction_2003);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.EmitEventAction_2013);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.LoopAction_2004);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.BranchAction_2005);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.InternalAction_2006);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.CollectionIteratorAction_2007);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.SetVariableAction_2008);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.AcquireAction_2012);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.ReleaseAction_2010);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.ForkAction_2011);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.RecoveryAction_2016);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.StartAction_3004);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.StopAction_3005);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.LoopAction_3006);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.InternalAction_3007);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.BranchAction_3009);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.ExternalCallAction_3012);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.EmitEventAction_3046);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.AcquireAction_3026);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.ReleaseAction_3020);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.ForkAction_3023);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.CollectionIteratorAction_3013);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.RecoveryAction_3057);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
            types.add(PalladioComponentModelElementTypes.SetVariableAction_3024);
        }
        return types;
    }

    /**
     * Gets the target edit part.
     *
     * @param request the request
     * @return the target edit part
     * @generated
     */
    public EditPart getTargetEditPart(Request request) {
        if (request instanceof CreateViewAndElementRequest) {
            CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor()
                    .getCreateElementRequestAdapter();
            IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
            if (type == PalladioComponentModelElementTypes.VariableUsage_3047) {
                return getChildBySemanticHint(PalladioComponentModelVisualIDRegistry
                        .getType(EmitEventActionInputVariableUsageEventEditPart.VISUAL_ID));
            }
        }
        return super.getTargetEditPart(request);
    }

    /**
     * The Class EmitEventActionFigure.
     *
     * @generated
     */
    public class EmitEventActionFigure extends RoundedRectangle {

        /** The figure component emit event action. @generated */
        private WrappingLabel fFigureComponentEmitEventAction;
        
        /** The figure emit event action compartment rectangle. @generated */
        private RectangleFigure fFigureEmitEventActionCompartmentRectangle;

        /**
         * Instantiates a new emit event action figure.
         *
         * @generated
         */
        public EmitEventActionFigure() {

            GridLayout layoutThis = new GridLayout();
            layoutThis.numColumns = 1;
            layoutThis.makeColumnsEqualWidth = true;
            layoutThis.horizontalSpacing = 0;
            layoutThis.verticalSpacing = 0;
            layoutThis.marginWidth = 0;
            layoutThis.marginHeight = 0;
            this.setLayoutManager(layoutThis);

            this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(8), getMapMode().DPtoLP(8)));
            this.setLineWidth(1);
            this.setMinimumSize(new Dimension(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));
            createContents();
        }

        /**
         * Creates the contents.
         *
         * @generated
         */
        private void createContents() {

            WrappingLabel stereotypeLabel0 = new WrappingLabel();
            stereotypeLabel0.setText("<<EmitEventAction>>");
            stereotypeLabel0.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode().DPtoLP(0), getMapMode()
                    .DPtoLP(2), getMapMode().DPtoLP(0)));

            GridData constraintStereotypeLabel0 = new GridData();
            constraintStereotypeLabel0.verticalAlignment = GridData.CENTER;
            constraintStereotypeLabel0.horizontalAlignment = GridData.CENTER;
            constraintStereotypeLabel0.horizontalIndent = 0;
            constraintStereotypeLabel0.horizontalSpan = 1;
            constraintStereotypeLabel0.verticalSpan = 1;
            constraintStereotypeLabel0.grabExcessHorizontalSpace = false;
            constraintStereotypeLabel0.grabExcessVerticalSpace = false;
            this.add(stereotypeLabel0, constraintStereotypeLabel0);

            fFigureComponentEmitEventAction = new WrappingLabel();
            fFigureComponentEmitEventAction.setText("myEmitEvent");
            fFigureComponentEmitEventAction.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode().DPtoLP(0),
                    getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

            GridData constraintFFigureComponentEmitEventAction = new GridData();
            constraintFFigureComponentEmitEventAction.verticalAlignment = GridData.CENTER;
            constraintFFigureComponentEmitEventAction.horizontalAlignment = GridData.CENTER;
            constraintFFigureComponentEmitEventAction.horizontalIndent = 0;
            constraintFFigureComponentEmitEventAction.horizontalSpan = 1;
            constraintFFigureComponentEmitEventAction.verticalSpan = 1;
            constraintFFigureComponentEmitEventAction.grabExcessHorizontalSpace = false;
            constraintFFigureComponentEmitEventAction.grabExcessVerticalSpace = false;
            this.add(fFigureComponentEmitEventAction, constraintFFigureComponentEmitEventAction);

            fFigureEmitEventActionCompartmentRectangle = new RectangleFigure();
            fFigureEmitEventActionCompartmentRectangle.setFill(false);
            fFigureEmitEventActionCompartmentRectangle.setOutline(false);
            fFigureEmitEventActionCompartmentRectangle.setLineWidth(1);
            fFigureEmitEventActionCompartmentRectangle.setMinimumSize(new Dimension(getMapMode().DPtoLP(0),
                    getMapMode().DPtoLP(0)));

            GridData constraintFFigureEmitEventActionCompartmentRectangle = new GridData();
            constraintFFigureEmitEventActionCompartmentRectangle.verticalAlignment = GridData.FILL;
            constraintFFigureEmitEventActionCompartmentRectangle.horizontalAlignment = GridData.FILL;
            constraintFFigureEmitEventActionCompartmentRectangle.horizontalIndent = 0;
            constraintFFigureEmitEventActionCompartmentRectangle.horizontalSpan = 1;
            constraintFFigureEmitEventActionCompartmentRectangle.verticalSpan = 1;
            constraintFFigureEmitEventActionCompartmentRectangle.grabExcessHorizontalSpace = true;
            constraintFFigureEmitEventActionCompartmentRectangle.grabExcessVerticalSpace = true;
            this.add(fFigureEmitEventActionCompartmentRectangle, constraintFFigureEmitEventActionCompartmentRectangle);

        }

        /** The my use local coordinates. @generated */
        private boolean myUseLocalCoordinates = false;

        /**
         * Use local coordinates.
         *
         * @return true, if successful
         * @generated
         */
        protected boolean useLocalCoordinates() {
            return myUseLocalCoordinates;
        }

        /**
         * Sets the use local coordinates.
         *
         * @param useLocalCoordinates the new use local coordinates
         * @generated
         */
        protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
            myUseLocalCoordinates = useLocalCoordinates;
        }

        /**
         * Gets the figure component emit event action.
         *
         * @return the figure component emit event action
         * @generated
         */
        public WrappingLabel getFigureComponentEmitEventAction() {
            return fFigureComponentEmitEventAction;
        }

        /**
         * Gets the figure emit event action compartment rectangle.
         *
         * @return the figure emit event action compartment rectangle
         * @generated
         */
        public RectangleFigure getFigureEmitEventActionCompartmentRectangle() {
            return fFigureEmitEventActionCompartmentRectangle;
        }

    }

}
