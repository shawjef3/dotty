package dotty.tools.dottydoc
package js

import scala.scalajs.{ js => sjs }
import sjs.Dynamic.global
import sjs.JSApp
import sjs.annotation.{ JSExport, JSName }
import org.scalajs.dom
import dom.document
import dom.webworkers.Worker
import model._
import html.EntityLayout

@JSExport object DottyDocJS {
  @JSExport def main(target: dom.html.Div) = {
    document.title = "Dotty " + EntityIndex.currentEntity.path.mkString(".")
    target.appendChild(EntityLayout(EntityIndex.currentEntity).html.render)
    hljs.initHighlightingOnLoad()
  }
}

/** Library wrapper for highlighting */
@sjs.native object hljs extends sjs.Object {
  def initHighlightingOnLoad(): sjs.Any = sjs.native
}
