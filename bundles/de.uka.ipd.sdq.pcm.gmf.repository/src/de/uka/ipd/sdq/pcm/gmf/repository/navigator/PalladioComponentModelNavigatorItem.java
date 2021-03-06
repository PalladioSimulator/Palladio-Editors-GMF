/*
 *Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.navigator;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class PalladioComponentModelNavigatorItem extends PalladioComponentModelAbstractNavigatorItem {

    /**
     * @generated
     */
    static {
        final Class[] supportedTypes = new Class[] { View.class, EObject.class };
        Platform.getAdapterManager().registerAdapters(new IAdapterFactory() {

            public Object getAdapter(Object adaptableObject, Class adapterType) {
                if (adaptableObject instanceof de.uka.ipd.sdq.pcm.gmf.repository.navigator.PalladioComponentModelNavigatorItem
                        && (adapterType == View.class || adapterType == EObject.class)) {
                    return ((de.uka.ipd.sdq.pcm.gmf.repository.navigator.PalladioComponentModelNavigatorItem) adaptableObject)
                            .getView();
                }
                return null;
            }

            public Class[] getAdapterList() {
                return supportedTypes;
            }
        }, de.uka.ipd.sdq.pcm.gmf.repository.navigator.PalladioComponentModelNavigatorItem.class);
    }

    /**
     * @generated
     */
    private View myView;

    /**
     * @generated
     */
    private boolean myLeaf = false;

    /**
     * @generated
     */
    public PalladioComponentModelNavigatorItem(View view, Object parent, boolean isLeaf) {
        super(parent);
        myView = view;
        myLeaf = isLeaf;
    }

    /**
     * @generated
     */
    public View getView() {
        return myView;
    }

    /**
     * @generated
     */
    public boolean isLeaf() {
        return myLeaf;
    }

    /**
     * @generated
     */
    public boolean equals(Object obj) {
        if (obj instanceof de.uka.ipd.sdq.pcm.gmf.repository.navigator.PalladioComponentModelNavigatorItem) {
            return EcoreUtil
                    .getURI(getView())
                    .equals(EcoreUtil
                            .getURI(((de.uka.ipd.sdq.pcm.gmf.repository.navigator.PalladioComponentModelNavigatorItem) obj)
                                    .getView()));
        }
        return super.equals(obj);
    }

    /**
     * @generated
     */
    public int hashCode() {
        return EcoreUtil.getURI(getView()).hashCode();
    }

}
