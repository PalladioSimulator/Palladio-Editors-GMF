/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.custom.edit.part;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageLoopIterationsLabelEditPart;
import de.uka.ipd.sdq.pcm.usagemodel.Loop;


public class CustomUsageLoopIterationsLabelEditPart extends UsageLoopIterationsLabelEditPart {

	private EContentAdapter changeListener = null;
	private EObject adaptedElement = null;

	public CustomUsageLoopIterationsLabelEditPart(View view) {
		super(view);
	}

	@Override
	protected String getLabelText() {
		String text = null;
		EObject object = resolveSemanticElement();
		if (object instanceof Loop) {
			Loop loop = (Loop) object;
			//Loop loop = (Loop) resolveSemanticElement();
			if (loop.getLoopIteration_Loop() != null) {
				text = "Iterations: "
						+ loop.getLoopIteration_Loop().getSpecification();
			}
			if (text == null || text.length() == 0) {
				text = getLabelTextHelper(getFigure());
			}
		}
		
		return text;
	}

	@Override
	protected void addSemanticListeners() {
		EObject element = resolveSemanticElement();
		changeListener = new EContentAdapter() {

			@Override
			public void notifyChanged(Notification notification) {
				super.notifyChanged(notification);
				CustomUsageLoopIterationsLabelEditPart.this
						.notifyChanged(notification);
			}

		};
		adaptedElement = element;
		element.eAdapters().add(changeListener);
		addListenerFilter("SemanticModel", this, element); //$NON-NLS-1$
	}

	@Override
	protected void removeSemanticListeners() {
		removeListenerFilter("SemanticModel"); //$NON-NLS-1$
		adaptedElement.eAdapters().remove(changeListener);
	}

	@Override
	protected void handleNotificationEvent(final Notification event) {
		Object feature = event.getFeature();
		if (NotationPackage.eINSTANCE.getFontStyle_FontColor().equals(feature)) {
			Integer c = (Integer) event.getNewValue();
			setFontColor(DiagramColorRegistry.getInstance().getColor(c));
		} else if (NotationPackage.eINSTANCE.getFontStyle_Underline().equals(
				feature)) {
			refreshUnderline();
		} else if (NotationPackage.eINSTANCE.getFontStyle_StrikeThrough()
				.equals(feature)) {
			refreshStrikeThrough();
		} else if (NotationPackage.eINSTANCE.getFontStyle_FontHeight().equals(
				feature)
				|| NotationPackage.eINSTANCE.getFontStyle_FontName().equals(
						feature)
				|| NotationPackage.eINSTANCE.getFontStyle_Bold()
						.equals(feature)
				|| NotationPackage.eINSTANCE.getFontStyle_Italic().equals(
						feature)) {
			refreshFont();
		} else {
			refreshLabel();
		}
		super.handleNotificationEvent(event);
	}
}
