const { Schema, model } = require("mongoose");

const noteSchema = new Schema({
    username: { type: String, require: true },
    date: { type: Date, require: true },
    note: { type: String, require: true }
});

module.exports = model("notes", noteSchema);
