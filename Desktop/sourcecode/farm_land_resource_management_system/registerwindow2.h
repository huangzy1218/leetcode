#ifndef REGISTERWINDOW2_H
#define REGISTERWINDOW2_H

#include <QWidget>

namespace Ui {
class RegisterWindow2;
}

class RegisterWindow2 : public QWidget
{
    Q_OBJECT

public:
    explicit RegisterWindow2(QWidget *parent = nullptr);
    ~RegisterWindow2();

private:
    Ui::RegisterWindow2 *ui;
};

#endif // REGISTERWINDOW2_H
