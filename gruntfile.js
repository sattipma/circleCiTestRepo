
module.exports = function (grunt) {
    grunt.initConfig({
        //pkg: grunt.file.readJSON('package.json'),
        unittesting: {
          //  unit: {
                src: ['test/unit.js']
           // }
        }
    });

   // grunt.loadTasks('grunt-unittesting');
   // grunt.registerTask('test', ['unittesting']);

    grunt.registerTask('test', 'A sample task that logs stuff.', function(arg1, arg2) {
        if (arguments.length === 0) {
          grunt.log.writeln(this.name + ", no args");
        } else {
          grunt.log.writeln(this.name + ", " + arg1 + " " + arg2);
        }
      }); 
}