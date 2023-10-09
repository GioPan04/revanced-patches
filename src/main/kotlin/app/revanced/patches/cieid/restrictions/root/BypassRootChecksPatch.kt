package app.revanced.patches.cieid.restrictions.root

import app.revanced.extensions.exception
import app.revanced.patcher.data.BytecodeContext
import app.revanced.patcher.extensions.InstructionExtensions.addInstruction
import app.revanced.patcher.patch.BytecodePatch
import app.revanced.patcher.patch.annotation.CompatiblePackage
import app.revanced.patcher.patch.annotation.Patch
import app.revanced.patches.cieid.restrictions.root.fingerprints.RootCheckerFingerprint

@Patch(
    name = "Bypass root checks",
    description = "Removes the restriction of using the app with root permissions or on a custom ROM.",
    compatiblePackages = [CompatiblePackage("it.ipzs.cieid")]
)
class BypassRootChecksPatch : BytecodePatch(
    setOf(RootCheckerFingerprint)
) {
    override fun execute(context: BytecodeContext) {
        val result = RootCheckerFingerprint.result ?: throw RootCheckerFingerprint.exception
        result.apply {
            mutableMethod.addInstruction(1, "return-void")
        }
    }
}