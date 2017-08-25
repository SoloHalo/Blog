package com.cql.blog.base;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by home on 2017/8/25.
 */

public abstract class BasePrenster<V extends BaseView, M extends BaseModel> {
    private V mView;
    private M mModel;
    private CompositeDisposable mCompositeDisposable;

    public V getView() {
        return mView;
    }

    public M getModel() {
        return mModel;
    }

    public void attach(V view, M model) {
        this.mView = view;
        this.mModel = model;
        if (this.mCompositeDisposable == null) {
            this.mCompositeDisposable = new CompositeDisposable();
        }
        this.onAttach(view);
    }

    public void detach() {
        this.mView = null;
        if (this.mCompositeDisposable != null) {
            this.mCompositeDisposable.clear();
        }
        this.onDetach();
    }

    protected <D> ObservableTransformer<D, D> bindLife() {
        return new ObservableTransformer<D, D>() {
            @Override
            public ObservableSource<D> apply(@NonNull Observable<D> upstream) {
                return upstream.doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        BasePrenster.this.mCompositeDisposable.add(disposable);
                    }
                });
            }
        };
    }

    public abstract void onAttach(V view);

    public abstract void onDetach();
}
