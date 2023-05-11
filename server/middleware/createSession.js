const bcrypt = require("bcrypt");

module.exports = async function (req, res, next) {
    try {
        const { username } = req.body;
        const saltRounds = 10;

        await bcrypt.hash(username + Date.now(), saltRounds, function (err, hash) {
            if (err || !hash) {
                return res.status(200).send(JSON.stringify({ success: false }));
            }

            req.body.sessionKey = hash;

            next();
        });
    } catch (err) {
        res.status(200).send(JSON.stringify({ success: false }));
    }
}
