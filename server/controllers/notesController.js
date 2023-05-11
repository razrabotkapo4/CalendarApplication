const config = require("config");
const mongoose = require("mongoose");

const Note = require("../models/Note");
const User = require("../models/User");

class NotesController {
    async add(req, res) {
        try {
            const { sessionKey, username, date, note } = req.body;

            await mongoose.connect(config.get("server.database.uri"));

            const userObject = await User.findOne({ sessionKey, username });

            if (!userObject) {
                return res.status(200).send(JSON.stringify({ success: false, description: "User rights not identified..." }));
            }

            const noteObject = await Note.updateOne({ username, date: new Date(date.split(".").reverse().join(".")) }, { note }, { upsert: true });

            res.status(200).send(JSON.stringify({ success: true }));
        } catch (err) {
            res.status(200).send(JSON.stringify({ success: false, description: "User rights not identified...", err: err.message }));
        } finally {
            await mongoose.disconnect();
        }
    }

    async remove(req, res) {
        try {
            const { sessionKey, username, date } = req.body;

            await mongoose.connect(config.get("server.database.uri"));

            const userObject = await User.findOne({ sessionKey, username });

            if (!userObject) {
                return res.status(200).send(JSON.stringify({ success: false, description: "User rights not identified..." }));
            }

            const noteObject = await Note.deleteOne({ username, date: new Date(date.split(".").reverse().join(".")) });

            res.status(200).send(JSON.stringify({ success: true }));
        } catch (err) {
            res.status(200).send(JSON.stringify({ success: false, description: "User rights not identified..." }));
        } finally {
            await mongoose.disconnect();
        }
    }
}

module.exports = new NotesController();
