package com.github.chinloyal.pusher_client

import androidx.annotation.NonNull
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result

/** PusherClientPlugin */
class PusherClientPlugin: FlutterPlugin, MethodCallHandler {

  private lateinit var channel: MethodChannel

  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    val channel = MethodChannel(flutterPluginBinding.binaryMessenger, "com.github.chinloyal/pusher_client")
    val streamChannel = EventChannel(flutterPluginBinding.binaryMessenger, "com.github.chinloyal/pusher_client_stream")
    streamChannel.setStreamHandler(this)
    channel.setMethodCallHandler(this)
  }

  override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
    // TODO: Handle method calls from Dart
    result.notImplemented()
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
  }
}


