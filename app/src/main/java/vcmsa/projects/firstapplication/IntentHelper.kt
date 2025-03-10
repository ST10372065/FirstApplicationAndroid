package vcmsa.projects.firstapplication

import android.content.Context
import android.content.Intent

fun openIntent(context: Context, order: String, activityToOpen: Class<*>){
    //declare intent with context and class to pass teh value to
    val intent = Intent(context, activityToOpen)
    // pass through the string value with key "order"
    intent.putExtra("order",order)
    // if context is not an activity, add FLAG_ACTIVITY_NEW_TASK
    if (context !is android.app.Activity){
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    // start the activity
    context.startActivity(intent)

}

fun shareIntent(context: Context, order: String) {
    val sendIntent =  Intent()
    //set the action to indicate what to do - send in this case
    sendIntent.action = Intent.ACTION_SEND
    sendIntent.putExtra(Intent.EXTRA_TEXT, order)
    //we are sending plain text
    sendIntent.type = "text/plain"
    //show the share sheet
    val shareIntent = Intent.createChooser(sendIntent, null)
    // if context is not an activity, add FLAG_ACTIVITY_NEW_TASK
    if (context !is android.app.Activity){
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    context.startActivity(shareIntent)
}