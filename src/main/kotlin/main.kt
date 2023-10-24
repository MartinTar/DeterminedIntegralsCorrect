import SLAE_methods_functions.SLAEAccurateMethods
import java.io.File
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.FileWriter
import java.lang.Math.*
import java.util.*
import kotlin.math.ln

fun main(args: Array<String>) {
    val func = ::function
    val integrator = Integrator();
    val a = 0.7
    val b = 3.2
    var fWrite: FileWriter

/*
    try {

        var leftRects = File("src/main/resources/leftRect.txt")

        fWrite = FileWriter(leftRects)

        var h = (b-a)
        for(i in 0..25) {
            h = (b-a)/pow(2.0, i.toDouble())
            fWrite.write("${h.toString()} ${integrator.leftRectangle(func, a, b, h)}\n")
        }

        fWrite.close()

    } catch (e: FileNotFoundException) {
        print("Файл для записи результатов метода левых треугольников не обнаружен")
        return
    } //левые треугольники с выводом в файл leftRect

    try {

        var midRect = File("src/main/resources/midRect.txt")

        fWrite = FileWriter(midRect)

        var h = (b-a)
        for(i in 0..25) {
            h = (b-a)/pow(2.0, i.toDouble())
            fWrite.write("${h.toString()} ${integrator.midRectangle(func, a, b, h)}\n")
        }

        fWrite.close()

    } catch (e: FileNotFoundException) {
        print("Файл для записи результатов метода средних треугольников не обнаружен")
        return
    } //средние треугольники с выводом в файл leftRect


    try {

        var trapezoid = File("src/main/resources/trapezoid.txt")

        fWrite = FileWriter(trapezoid)

        var h = (b-a)
        for(i in 0..25) {
            h = (b-a)/pow(2.0, i.toDouble())
            fWrite.write("${h.toString()} ${integrator.trapezoid(func, a, b, h)}\n")
        }

        fWrite.close()

    } catch (e: FileNotFoundException) {
        print("Файл для записи результатов метода трапеции не обнаружен")
        return
    } //трапеции с выводом в файл leftRect

    try {

        var simson = File("src/main/resources/simson.txt")

        fWrite = FileWriter(simson)

        var h = (b-a)
        for(i in 0..25) {
            h = (b-a)/pow(2.0, i.toDouble())
            fWrite.write("${h.toString()} ${integrator.simson(func, a, b, h)}\n")
        }

        fWrite.close()

    } catch (e: FileNotFoundException) {
        print("Файл для записи результатов метода Симсона не обнаружен")
        return
    } //Симсон с выводом в файл simson
*/

  /*  try {

        var gauss = File("src/main/resources/gauss.txt")

        fWrite = FileWriter(gauss)

        var h = (b-a)
        for(i in 0..7) {
            h = (b-a)/pow(2.0, i.toDouble())
            fWrite.write("${h.toString()} ${integrator.gauss(func, a, b, h)}\n")
        }

        fWrite.close()

    } catch (e: FileNotFoundException) {
        print("Файл для записи результатов метода Гаусса не обнаружен")
        return
    } //Симсон с выводом в файл leftRect
*/
 /*   try {

        var cots = File("src/main/resources/cots.txt")

        fWrite = FileWriter(cots)

        var h = (b-a)
        for(i in 0..10) {
            h = (b-a)/pow(2.0, i.toDouble())
            fWrite.write("${h.toString()} ${integrator.newtonCots(func, a, b, h)}\n")
        }

        fWrite.close()

    } catch (e: FileNotFoundException) {
        print("Файл для записи результатов метода Ньютона-Котса не обнаружен")
        return
    }
*/
/*

    val epsilon = pow(10.0, -6.0)
    var h = b-a
    var s1 = integrator.newtonCots(func, a, b, h)
    var s2 = integrator.newtonCots(func, a, b, h/2)
    var s3 = integrator.newtonCots(func, a, b, h/4)

    var m: Double = kotlin.math.round(-1 * (ln(abs((s3-s2)/(s2-s1)))/ln(2.0)))
    var bVect = arrayOf<DoubleArray>(doubleArrayOf(s3-s2), doubleArrayOf(s2-s1))
    var cMatrix = arrayOf<DoubleArray>(doubleArrayOf(pow(h, m)*(pow(2.0, -1*m) - pow(4.0, -1*m)), pow(h, m)*(pow(2.0, -1*m-1) - pow(4.0, -1*m-1))),
                                                        doubleArrayOf(pow(h, m)*(1 - pow(2.0, -1*m)), pow(h, m)*(1 - pow(2.0, -1*m-1))))
    var c = SLAEAccurateMethods.GaussMethod(cMatrix, bVect)
    var r3 = c[0][0]*pow(h/4, m) + c[1][0]*pow(h/4, m+1)

    while(r3 >= epsilon) {
        h /= 2

        s1 = s2
        s2 = s3
        s3 = integrator.newtonCots(func, a, b, h/4)

        m = kotlin.math.round(-1 * (ln(abs((s3-s2)/(s2-s1)))/ln(2.0)))
        bVect = arrayOf<DoubleArray>(doubleArrayOf(s3-s2), doubleArrayOf(s2-s1))
        cMatrix = arrayOf<DoubleArray>(doubleArrayOf(pow(h, m)*(pow(2.0, -1*m) - pow(4.0, -1*m)), pow(h, m)*(pow(2.0, -1*m-1) - pow(4.0, -1*m-1))),
            doubleArrayOf(pow(h, m)*(1 - pow(2.0, -1*m)), pow(h, m)*(1 - pow(2.0, -1*m-1))))
        c = SLAEAccurateMethods.GaussMethod(cMatrix, bVect)
        r3 = c[0][0]*pow(h/4, m) + c[1][0]*pow(h/4, m+1)

    }

    println("Решаем задачу методом Ньютона Котса, для уточнения применяем метод ричардсона при r=2, для задания m применям процесс Эйткина на 3 сетках")
    println("Итоговая длина частичного отрезка для заданной точности ${epsilon}: ${h/4}.\n Итоговое значение интеграла: ${s3}")
*/

/*
    val epsilon = pow(10.0, -6.0)
    var h = b-a
    var s1 = integrator.gauss(func, a, b, h)
    var s2 = integrator.gauss(func, a, b, h/2)
    var s3 = integrator.gauss(func, a, b, h/4)

    var m: Double = kotlin.math.round(-1 * (ln(abs((s3-s2)/(s2-s1)))/ln(2.0)))
    var bVect = arrayOf<DoubleArray>(doubleArrayOf(s3-s2), doubleArrayOf(s2-s1))
    var cMatrix = arrayOf<DoubleArray>(doubleArrayOf(pow(h, m)*(pow(2.0, -1*m) - pow(4.0, -1*m)), pow(h, m)*(pow(2.0, -1*m-1) - pow(4.0, -1*m-1))),
        doubleArrayOf(pow(h, m)*(1 - pow(2.0, -1*m)), pow(h, m)*(1 - pow(2.0, -1*m-1))))
    var c = SLAEAccurateMethods.GaussMethod(cMatrix, bVect)
    var r3 = c[0][0]*pow(h/4, m) + c[1][0]*pow(h/4, m+1)

    while(r3 >= epsilon) {
        h /= 2

        s1 = s2
        s2 = s3
        s3 = integrator.gauss(func, a, b, h/4)

        m = kotlin.math.round(-1 * (ln(abs((s3-s2)/(s2-s1)))/ln(2.0)))
        bVect = arrayOf<DoubleArray>(doubleArrayOf(s3-s2), doubleArrayOf(s2-s1))
        cMatrix = arrayOf<DoubleArray>(doubleArrayOf(pow(h, m)*(pow(2.0, -1*m) - pow(4.0, -1*m)), pow(h, m)*(pow(2.0, -1*m-1) - pow(4.0, -1*m-1))),
            doubleArrayOf(pow(h, m)*(1 - pow(2.0, -1*m)), pow(h, m)*(1 - pow(2.0, -1*m-1))))
        c = SLAEAccurateMethods.GaussMethod(cMatrix, bVect)
        r3 = c[0][0]*pow(h/4, m) + c[1][0]*pow(h/4, m+1)

        println(r3)
    }

    println("Решаем задачу методом Гаусса, для уточнения применяем метод ричардсона при r=2, для задания m применям процесс Эйткина на 3 сетках")
    println("Итоговая длина частичного отрезка для заданной точности ${epsilon}: ${h/4}.\n Итоговое значение интеграла: ${s3}")
*/

    val epsilon = pow(10.0, -6.0)
    var h = b-a
    var s1 = integrator.gauss(func, a, b, h)
    var s2 = integrator.gauss(func, a, b, h/2)
    var s3 = integrator.gauss(func, a, b, h/4)

    var m: Double = kotlin.math.round(-1 * (ln(abs((s3-s2)/(s2-s1)))/ln(2.0)))
    var bVect = arrayOf<DoubleArray>(doubleArrayOf(s3-s2), doubleArrayOf(s2-s1))
    var cMatrix = arrayOf<DoubleArray>(doubleArrayOf(pow(h, m)*(pow(2.0, -1*m) - pow(4.0, -1*m)), pow(h, m)*(pow(2.0, -1*m-1) - pow(4.0, -1*m-1))),
        doubleArrayOf(pow(h, m)*(1 - pow(2.0, -1*m)), pow(h, m)*(1 - pow(2.0, -1*m-1))))
    var c = SLAEAccurateMethods.GaussMethod(cMatrix, bVect)
    var r3 = c[0][0]*pow(h/4, m) + c[1][0]*pow(h/4, m+1)

    var h_opt = h*pow(epsilon/abs(c[0][0]*pow(h, m) + c[1][0]*pow(h, m+1)), 1.0/m)
    var s_opt = integrator.gauss(func, a, b, h_opt)
    var r_opt = c[0][0]*pow(h_opt, m) + c[1][0]*pow(h_opt, m+1)

    while(r_opt >= epsilon) {
        h = h_opt

        s1 = integrator.gauss(func, a, b, h)
        s2 = integrator.gauss(func, a, b, h/2)
        s3 = integrator.gauss(func, a, b, h/4)

        m = kotlin.math.round(-1 * (ln(abs((s3-s2)/(s2-s1)))/ln(2.0)))
        bVect = arrayOf<DoubleArray>(doubleArrayOf(s3-s2), doubleArrayOf(s2-s1))
        cMatrix = arrayOf<DoubleArray>(doubleArrayOf(pow(h, m)*(pow(2.0, -1*m) - pow(4.0, -1*m)), pow(h, m)*(pow(2.0, -1*m-1) - pow(4.0, -1*m-1))),
            doubleArrayOf(pow(h, m)*(1 - pow(2.0, -1*m)), pow(h, m)*(1 - pow(2.0, -1*m-1))))
        c = SLAEAccurateMethods.GaussMethod(cMatrix, bVect)
        r3 = c[0][0]*pow(h/4, m) + c[1][0]*pow(h/4, m+1)


       h_opt = h*pow(epsilon/abs(c[0][0]*pow(h, m) + c[1][0]*pow(h, m+1)), 1.0/m)
       s_opt = integrator.gauss(func, a, b, h_opt)
       r_opt = c[0][0]*pow(h_opt, m) + c[1][0]*pow(h_opt, m+1)

    }

    println("Решаем задачу методом Гаусса, для уточнения применяем метод ричардсона при r=2, для задания m применям процесс Эйткина на 3 сетках")
    println("Итоговая длина частичного отрезка (оптимального) для заданной точности ${epsilon}: ${h_opt}.\nИтоговое значение интеграла: ${s_opt}")

}

