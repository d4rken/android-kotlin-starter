package eu.darken.androidkotlinstarter.main.ui.fragment

import android.content.Context
import com.bumptech.glide.Priority
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.Options
import com.bumptech.glide.load.data.DataFetcher
import com.bumptech.glide.load.model.ModelLoader
import com.bumptech.glide.load.model.ModelLoaderFactory
import com.bumptech.glide.load.model.MultiModelLoaderFactory
import com.bumptech.glide.signature.ObjectKey


class TestModelLoader internal constructor(private val context: Context) : ModelLoader<String, String> {

    override fun buildLoadData(testData: String, width: Int, height: Int, options: Options): ModelLoader.LoadData<String>? {
        return ModelLoader.LoadData<String>(ObjectKey(testData), TestFetcher(context, testData))
    }

    override fun handles(file: String): Boolean {
        return true
    }

    private class TestFetcher internal constructor(private val context: Context, private val testData: String) : DataFetcher<String> {

        override fun loadData(priority: Priority, callback: DataFetcher.DataCallback<in String>) {
            callback.onDataReady(testData)
        }

        override fun cleanup() {}

        override fun cancel() {}

        override fun getDataClass(): Class<String> {
            return String::class.java
        }

        override fun getDataSource(): DataSource {
            return DataSource.LOCAL
        }
    }

    class Factory(private val context: Context) : ModelLoaderFactory<String, String> {

        override fun build(multiFactory: MultiModelLoaderFactory): ModelLoader<String, String> {
            return TestModelLoader(context)
        }

        override fun teardown() {}
    }
}
