/*
                             MIT License

                        Copyright (c) 2021 uin

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package io.github.uinnn.serializer

/**
 * A StringSerialFile is a [SerialFile] for String format
 * files, such as JSON and YAML.
 */
interface StringSerialFile<T : Any> : SerialFile<T> {
  override var format: AlterableStringFormat

  override fun load() {
    super.load()
    createFile()
    reload()
  }

  override fun reload() {
    super.reload()
    settings = format.decodeFromString(serial, file.readText())
  }

  override fun saveModel() {
    super.saveModel()
    file.writeText(format.encodeToString(serial, model))
  }

  override fun save() {
    super.save()
    file.writeText(format.encodeToString(serial, settings))
  }
}