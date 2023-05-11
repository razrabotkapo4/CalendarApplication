const bcrypt = require("bcrypt");

module.exports = async function (req, res, next) {
    try {
        const { password } = req.body;
        const saltRounds = 10;

        await bcrypt.hash(password, saltRounds, function (err, hash) {
            if (err || !hash) {
                return res.status(200).send(JSON.stringify({ success: false }));
            }

            req.body.password = hash;

            next();
        });
    } catch (err) {
        res.status(200).send(JSON.stringify({ success: false }));
    }
}
