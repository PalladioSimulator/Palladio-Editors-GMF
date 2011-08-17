/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.StartActionItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class StartActionEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2001;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public StartActionEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new StartActionItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child
						.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
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
	 * @generated
	 */
	protected IFigure createNodeShape() {
		StartFigure figure = new StartFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public StartFigure getPrimaryShape() {
		return (StartFigure) primaryShape;
	}

	/**
	 * @generated not
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode()
				.DPtoLP(20), getMapMode().DPtoLP(20)) {

			@Override
			protected ConnectionAnchor createDefaultAnchor() {
				return new EllipseAnchor(this);
			}

		};
		return result;
	}

	/**
	 * @generated
	 */
	public EditPolicy getPrimaryDragEditPolicy() {
		EditPolicy result = super.getPrimaryDragEditPolicy();
		if (result instanceof ResizableEditPolicy) {
			ResizableEditPolicy ep = (ResizableEditPolicy) result;
			ep.setResizeDirections(PositionConstants.NONE);
		}
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
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
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types
				.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (targetEditPart instanceof de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartActionEditPart) {
			types
					.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof StopActionEditPart) {
			types
					.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof ExternalCallActionEditPart) {
			types
					.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof EmitEventActionEditPart) {
			types
					.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof LoopActionEditPart) {
			types
					.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof BranchActionEditPart) {
			types
					.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof InternalActionEditPart) {
			types
					.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof CollectionIteratorActionEditPart) {
			types
					.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof SetVariableActionEditPart) {
			types
					.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof AcquireActionEditPart) {
			types
					.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof ReleaseActionEditPart) {
			types
					.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof ForkActionEditPart) {
			types
					.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof RecoveryBlockActionEditPart) {
			types
					.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof StartAction2EditPart) {
			types
					.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof StopAction2EditPart) {
			types
					.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof LoopAction2EditPart) {
			types
					.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof InternalAction2EditPart) {
			types
					.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof BranchAction2EditPart) {
			types
					.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof ExternalCallAction2EditPart) {
			types
					.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof EmitEventAction2EditPart) {
			types
					.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof AcquireAction2EditPart) {
			types
					.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof ReleaseAction2EditPart) {
			types
					.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof ForkAction2EditPart) {
			types
					.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof CollectionIteratorAction2EditPart) {
			types
					.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof RecoveryBlockAction2EditPart) {
			types
					.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof SetVariableAction2EditPart) {
			types
					.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(
			IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.StartAction_2001);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.StopAction_2002);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types
					.add(PalladioComponentModelElementTypes.ExternalCallAction_2003);
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
			types
					.add(PalladioComponentModelElementTypes.CollectionIteratorAction_2007);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types
					.add(PalladioComponentModelElementTypes.SetVariableAction_2008);
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
			types
					.add(PalladioComponentModelElementTypes.RecoveryBlockAction_2015);
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
			types
					.add(PalladioComponentModelElementTypes.ExternalCallAction_3012);
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
			types
					.add(PalladioComponentModelElementTypes.CollectionIteratorAction_3013);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types
					.add(PalladioComponentModelElementTypes.RecoveryBlockAction_3056);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types
					.add(PalladioComponentModelElementTypes.SetVariableAction_3024);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types
				.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(
			IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.StartAction_2001);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.StopAction_2002);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types
					.add(PalladioComponentModelElementTypes.ExternalCallAction_2003);
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
			types
					.add(PalladioComponentModelElementTypes.CollectionIteratorAction_2007);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types
					.add(PalladioComponentModelElementTypes.SetVariableAction_2008);
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
			types
					.add(PalladioComponentModelElementTypes.RecoveryBlockAction_2015);
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
			types
					.add(PalladioComponentModelElementTypes.ExternalCallAction_3012);
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
			types
					.add(PalladioComponentModelElementTypes.CollectionIteratorAction_3013);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types
					.add(PalladioComponentModelElementTypes.RecoveryBlockAction_3056);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types
					.add(PalladioComponentModelElementTypes.SetVariableAction_3024);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class StartFigure extends Ellipse {
		/**
		 * @generated
		 */
		public StartFigure() {
			this.setLineWidth(1);
			this.setBackgroundColor(ColorConstants.black);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(20),
					getMapMode().DPtoLP(20)));
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(0)));
		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		/**
		 * @generated
		 */
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

		/**
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}

	}
}
