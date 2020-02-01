package com.example.mytask.databinding;
import com.example.mytask.R;
import com.example.mytask.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemCategoryBindingImpl extends ItemCategoryBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.shadow, 4);
    }
    // views
    @NonNull
    private final androidx.cardview.widget.CardView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemCategoryBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ItemCategoryBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[1]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            , (android.view.View) bindings[4]
            );
        this.categoryImage.setTag(null);
        this.categoryName.setTag(null);
        this.categoryType.setTag(null);
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.category == variableId) {
            setCategory((com.example.mytask.model.Category) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setCategory(@Nullable com.example.mytask.model.Category Category) {
        this.mCategory = Category;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.category);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String categoryCategoryIcon = null;
        com.example.mytask.model.Category category = mCategory;
        java.lang.String categoryCategoryTitleEn = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (category != null) {
                    // read category.category_icon
                    categoryCategoryIcon = category.getCategory_icon();
                    // read category.category_title_en
                    categoryCategoryTitleEn = category.getCategory_title_en();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.example.mytask.Util.GlideBinding.loadImage(this.categoryImage, categoryCategoryIcon);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.categoryName, categoryCategoryTitleEn);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.categoryType, categoryCategoryTitleEn);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): category
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}