package app.revanced.patches.reddit.customclients.infinityforreddit.api.fingerprints

import app.revanced.patcher.fingerprint.method.impl.MethodFingerprint

object SetWebViewSettingsFingerprint : MethodFingerprint(
    strings= listOf("https://www.reddit.com/api/v1/authorize.compact")
)