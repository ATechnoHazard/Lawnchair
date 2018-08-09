package ch.deletescape.lawnchair.globalsearch

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.support.annotation.Keep
import ch.deletescape.lawnchair.colors.ColorEngine
import com.android.launcher3.R
import com.android.launcher3.util.PackageManagerHelper

@Keep
class DuckDuckGoSearchProvider(context: Context) : SearchProvider(context) {

    private val PACKAGE = "com.duckduckgo.mobile.android"

    override val name = context.getString(R.string.search_provider_ddg)!!
    override val supportsVoiceSearch: Boolean
        get() = false
    override val supportsAssistant: Boolean
        get() = false

    override val isAvailable: Boolean
        get() = PackageManagerHelper.isAppEnabled(context.packageManager, PACKAGE, 0)

    override fun startSearch(callback: (intent: Intent) -> Unit) = callback(Intent(Intent.ACTION_ASSIST).setPackage(PACKAGE))

    override fun getIcon(colored: Boolean): Drawable = context.getDrawable(R.drawable.ic_search).apply {
        setTint(if (colored) ColorEngine.getInstance(context).accent else Color.WHITE)
    }

}