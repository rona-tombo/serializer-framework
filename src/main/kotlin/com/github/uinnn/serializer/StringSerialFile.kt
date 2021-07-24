package com.github.uinnn.serializer

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