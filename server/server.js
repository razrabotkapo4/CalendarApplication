const config = require("config");
const express = require("express");
const bodyParser = require("body-parser");

const authorizationRouter = require("./routers/authorizationRouter");
const notesRouter = require("./routers/notesRouter");

try {
    const app = express();
    const port = config.get("server.port") || 3000;

    app.use(bodyParser.json());

    app.use("/authorization", authorizationRouter);
    app.use("/notes", notesRouter);

    app.listen(port, () => console.log(new Date().toString()));
} catch (err) {
    console.log(err);
}
