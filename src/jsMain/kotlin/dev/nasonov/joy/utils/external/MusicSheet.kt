package dev.nasonov.joy.utils.external

import kotlin.js.Promise

@JsModule("opensheetmusicdisplay")
@JsNonModule
external object opensheetmusicdisplay {
    class OpenSheetMusicDisplay(string: String) {
        fun load(content: String): Promise<Any>
        fun setOptions(options: IOSMDOptions )
        fun render()
    }

}
external interface IOSMDOptions {
    var alignRests: dynamic /* AlignRestOption? | Number? */
        get() = definedExternally
        set(value) = definedExternally
    var autoBeam: Boolean?
        get() = definedExternally
        set(value) = definedExternally
//    var autoBeamOptions: AutoBeamOptions?
//        get() = definedExternally
//        set(value) = definedExternally
    var autoResize: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var backend: String?
        get() = definedExternally
        set(value) = definedExternally
//    var coloringMode: ColoringModes?
//        get() = definedExternally
//        set(value) = definedExternally
    var coloringSetCustom: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var coloringEnabled: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var colorStemsLikeNoteheads: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var darkMode: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var defaultColorMusic: String?
        get() = definedExternally
        set(value) = definedExternally
    var defaultColorNotehead: String?
        get() = definedExternally
        set(value) = definedExternally
    var defaultColorStem: String?
        get() = definedExternally
        set(value) = definedExternally
    var defaultColorRest: String?
        get() = definedExternally
        set(value) = definedExternally
    var defaultColorLabel: String?
        get() = definedExternally
        set(value) = definedExternally
    var defaultColorTitle: String?
        get() = definedExternally
        set(value) = definedExternally
    var defaultFontFamily: String?
        get() = definedExternally
        set(value) = definedExternally
//    var defaultFontStyle: FontStyles?
//        get() = definedExternally
//        set(value) = definedExternally
    var disableCursor: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var followCursor: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var drawingParameters: dynamic /* String? | DrawingParametersEnum? */
        get() = definedExternally
        set(value) = definedExternally
    var drawCredits: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var drawTitle: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var drawSubtitle: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var drawComposer: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var drawLyricist: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var drawMetronomeMarks: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var drawPartNames: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var drawPartAbbreviations: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var drawMeasureNumbers: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var drawMeasureNumbersOnlyAtSystemStart: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var drawTimeSignatures: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var measureNumberInterval: Number?
        get() = definedExternally
        set(value) = definedExternally
    var useXMLMeasureNumbers: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var drawFingerings: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var fingeringPosition: String?
        get() = definedExternally
        set(value) = definedExternally
    var fingeringInsideStafflines: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var drawHiddenNotes: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var drawLyrics: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var drawSlurs: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var drawUpToMeasureNumber: Number?
        get() = definedExternally
        set(value) = definedExternally
    var drawUpToSystemNumber: Number?
        get() = definedExternally
        set(value) = definedExternally
    var drawUpToPageNumber: Number?
        get() = definedExternally
        set(value) = definedExternally
    var drawFromMeasureNumber: Number?
        get() = definedExternally
        set(value) = definedExternally
    var fillEmptyMeasuresWithWholeRest: dynamic /* FillEmptyMeasuresWithWholeRests? | Number? */
        get() = definedExternally
        set(value) = definedExternally
    var setWantedStemDirectionByXml: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var tupletsRatioed: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var tupletsBracketed: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var tripletsBracketed: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var pageFormat: String?
        get() = definedExternally
        set(value) = definedExternally
    var pageBackgroundColor: String?
        get() = definedExternally
        set(value) = definedExternally
    var renderSingleHorizontalStaffline: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var newSystemFromXML: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var newPageFromXML: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    val onXMLRead: ((xml: String) -> String)?
    var percussionOneLineCutoff: Number?
        get() = definedExternally
        set(value) = definedExternally
    var percussionForceVoicesOneLineCutoff: Number?
        get() = definedExternally
        set(value) = definedExternally
    var spacingFactorSoftmax: Number?
        get() = definedExternally
        set(value) = definedExternally
    var spacingBetweenTextLines: Number?
        get() = definedExternally
        set(value) = definedExternally
    var stretchLastSystemLine: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var autoGenerateMutipleRestMeasuresFromRestMeasures: Boolean?
        get() = definedExternally
        set(value) = definedExternally
//    var cursorsOptions: Array<CursorOptions>?
//        get() = definedExternally
//        set(value) = definedExternally
}

/*
var osmd = new dev.nasonov.joy.utils.external.opensheetmusicdisplay.OpenSheetMusicDisplay("osmdContainer");
  osmd.setOptions({
    backend: "svg",
    drawTitle: true,
    // drawingParameters: "compacttight" // don't display title, composer etc., smaller margins
  });
  osmd
    .load("http://downloads2.makemusic.com/musicxml/MozaVeilSample.xml")
    .then(
      function() {
        osmd.render();
      }
    );
 */