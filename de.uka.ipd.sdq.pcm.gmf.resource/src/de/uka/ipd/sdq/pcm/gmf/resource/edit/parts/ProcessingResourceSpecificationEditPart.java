/*
 * Copyright 2009, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.resource.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.RectangleFigure;
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
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import de.uka.ipd.sdq.pcm.dialogs.resource.OpenProcessingRateDialog;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.policies.ProcessingResourceSpecificationItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.resource.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class ProcessingResourceSpecificationEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3001;

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
	public ProcessingResourceSpecificationEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ProcessingResourceSpecificationItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE,
				new OpenProcessingRateDialog());
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
		ProcessingResourceSpecificationFigure figure = new ProcessingResourceSpecificationFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ProcessingResourceSpecificationFigure getPrimaryShape() {
		return (ProcessingResourceSpecificationFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ProcessingResourceSpecificationMTTREditPart) {
			((ProcessingResourceSpecificationMTTREditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureMTTRFigure());
			return true;
		}
		if (childEditPart instanceof ProcessingResourceSpecificationSchedulingPolicyEditPart) {
			((ProcessingResourceSpecificationSchedulingPolicyEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureSchedulingPolicyFigure());
			return true;
		}
		if (childEditPart instanceof ProcessingResourceSpecificationNumberOfReplicasEditPart) {
			((ProcessingResourceSpecificationNumberOfReplicasEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureNoOfReplicasFigure());
			return true;
		}
		if (childEditPart instanceof ProcessingResourceSpecificationActiveResourceTypeLabelEditPart) {
			((ProcessingResourceSpecificationActiveResourceTypeLabelEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureActiveResourceTypeFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabelEditPart) {
			((WrappingLabelEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureProcessingRateFigure());
			return true;
		}
		if (childEditPart instanceof ProcessingResourceSpecificationMTTFEditPart) {
			((ProcessingResourceSpecificationMTTFEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureMTTFFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ProcessingResourceSpecificationMTTREditPart) {
			return true;
		}
		if (childEditPart instanceof ProcessingResourceSpecificationSchedulingPolicyEditPart) {
			return true;
		}
		if (childEditPart instanceof ProcessingResourceSpecificationNumberOfReplicasEditPart) {
			return true;
		}
		if (childEditPart instanceof ProcessingResourceSpecificationActiveResourceTypeLabelEditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabelEditPart) {
			return true;
		}
		if (childEditPart instanceof ProcessingResourceSpecificationMTTFEditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
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
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
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
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(PalladioComponentModelVisualIDRegistry
				.getType(ProcessingResourceSpecificationMTTFEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class ProcessingResourceSpecificationFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureProcessingRateFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureSchedulingPolicyFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureMTTFFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureMTTRFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureActiveResourceTypeFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureNoOfReplicasFigure;

		/**
		 * @generated
		 */
		public ProcessingResourceSpecificationFigure() {
			this.setFill(false);
			this.setOutline(false);
			this.setLineWidth(1);
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(0)));
			this.setBorder(new LineBorder(null, getMapMode().DPtoLP(1)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureActiveResourceTypeFigure = new WrappingLabel();
			fFigureActiveResourceTypeFigure
					.setText("ProcessingResourceSpecification");
			fFigureActiveResourceTypeFigure
					.setForegroundColor(ColorConstants.lightGray);

			this.add(fFigureActiveResourceTypeFigure);

			fFigureSchedulingPolicyFigure = new WrappingLabel();
			fFigureSchedulingPolicyFigure.setText("");

			this.add(fFigureSchedulingPolicyFigure);

			fFigureNoOfReplicasFigure = new WrappingLabel();
			fFigureNoOfReplicasFigure.setText("");

			this.add(fFigureNoOfReplicasFigure);

			fFigureProcessingRateFigure = new WrappingLabel();
			fFigureProcessingRateFigure.setText("");

			this.add(fFigureProcessingRateFigure);

			fFigureMTTFFigure = new WrappingLabel();
			fFigureMTTFFigure.setText("");

			this.add(fFigureMTTFFigure);

			fFigureMTTRFigure = new WrappingLabel();
			fFigureMTTRFigure.setText("");

			this.add(fFigureMTTRFigure);

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

		/**
		 * @generated
		 */
		public WrappingLabel getFigureProcessingRateFigure() {
			return fFigureProcessingRateFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureSchedulingPolicyFigure() {
			return fFigureSchedulingPolicyFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureMTTFFigure() {
			return fFigureMTTFFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureMTTRFigure() {
			return fFigureMTTRFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureActiveResourceTypeFigure() {
			return fFigureActiveResourceTypeFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureNoOfReplicasFigure() {
			return fFigureNoOfReplicasFigure;
		}

	}

}
