#ifndef APPROVALWINDOW_H
#define APPROVALWINDOW_H

#include <QWidget>

namespace Ui {
class ApprovalWindow;
}

class ApprovalWindow : public QWidget
{
    Q_OBJECT

public:
    explicit ApprovalWindow(QWidget *parent = nullptr);
    ~ApprovalWindow();

private:
    Ui::ApprovalWindow *ui;
};

#endif // APPROVALWINDOW_H
